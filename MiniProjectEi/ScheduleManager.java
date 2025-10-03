import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScheduleManager {
    private static final Logger LOGGER = Logger.getLogger(ScheduleManager.class.getName());

    private static final ScheduleManager INSTANCE = new ScheduleManager();

    private final List<Task> tasks = new ArrayList<>();
    private final List<NotificationObserver> observers = new ArrayList<>();

    private ScheduleManager() {}

    public static ScheduleManager getInstance() {
        return INSTANCE;
    }

    public void addObserver(NotificationObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(NotificationObserver observer) {
        observers.remove(observer);
    }

    public synchronized boolean addTask(Task task) {
        for (Task existing : tasks) {
            if (task.overlaps(existing)) {
                notifyConflict(task, existing);
                LOGGER.log(Level.WARNING, "Conflict when adding task {0} with existing {1}", new Object[]{task.getDescription(), existing.getDescription()});
                return false;
            }
        }
        tasks.add(task);
        sortTasks();
        notifyAdded(task);
        LOGGER.log(Level.INFO, "Task added: {0}", task.getDescription());
        return true;
    }

    public synchronized boolean removeTask(String description) {
        Optional<Task> found = tasks.stream()
                .filter(t -> t.getDescription().equalsIgnoreCase(description))
                .findFirst();
        if (found.isPresent()) {
            Task toRemove = found.get();
            tasks.remove(toRemove);
            notifyRemoved(toRemove);
            LOGGER.log(Level.INFO, "Task removed: {0}", toRemove.getDescription());
            return true;
        }
        LOGGER.log(Level.WARNING, "Task not found for removal: {0}", description);
        return false;
    }

    public synchronized boolean updateTask(String description, Task updated) {
        Optional<Task> found = tasks.stream()
                .filter(t -> t.getDescription().equalsIgnoreCase(description))
                .findFirst();
        if (!found.isPresent()) {
            LOGGER.log(Level.WARNING, "Task not found for update: {0}", description);
            return false;
        }
        Task oldTask = found.get();
        // Temporarily remove old task to validate conflicts
        tasks.remove(oldTask);
        for (Task existing : tasks) {
            if (updated.overlaps(existing)) {
                // put back old task and notify conflict
                tasks.add(oldTask);
                sortTasks();
                notifyConflict(updated, existing);
                LOGGER.log(Level.WARNING, "Conflict when updating task {0}", description);
                return false;
            }
        }
        tasks.add(updated);
        sortTasks();
        notifyUpdated(oldTask, updated);
        LOGGER.log(Level.INFO, "Task updated: {0}", description);
        return true;
    }

    public synchronized boolean markCompleted(String description) {
        Optional<Task> found = tasks.stream()
                .filter(t -> t.getDescription().equalsIgnoreCase(description))
                .findFirst();
        if (found.isPresent()) {
            found.get().markCompleted();
            LOGGER.log(Level.INFO, "Task marked complete: {0}", description);
            return true;
        }
        LOGGER.log(Level.WARNING, "Task not found to complete: {0}", description);
        return false;
    }

    public synchronized List<Task> viewAll() {
        List<Task> copy = new ArrayList<>(tasks);
        Collections.sort(copy);
        return copy;
    }

    public synchronized List<Task> viewByPriority(Priority priority) {
        List<Task> filtered = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getPriority() == priority) {
                filtered.add(task);
            }
        }
        filtered.sort(Comparator.naturalOrder());
        return filtered;
    }

    private void sortTasks() {
        tasks.sort(Comparator.naturalOrder());
    }

    private void notifyConflict(Task newTask, Task conflicting) {
        for (NotificationObserver observer : observers) {
            observer.onConflict(newTask, conflicting);
        }
    }

    private void notifyAdded(Task task) {
        for (NotificationObserver observer : observers) {
            observer.onTaskAdded(task);
        }
    }

    private void notifyRemoved(Task task) {
        for (NotificationObserver observer : observers) {
            observer.onTaskRemoved(task);
        }
    }

    private void notifyUpdated(Task oldTask, Task updatedTask) {
        for (NotificationObserver observer : observers) {
            observer.onTaskUpdated(oldTask, updatedTask);
        }
    }
}


