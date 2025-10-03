public class ConsoleNotifier implements NotificationObserver {
    @Override
    public void onConflict(Task newTask, Task conflictingTask) {
        System.out.println("Error: Task conflicts with existing task \"" + conflictingTask.getDescription() + "\".");
    }

    @Override
    public void onTaskAdded(Task task) {
        System.out.println("Task added successfully. No conflicts.");
    }

    @Override
    public void onTaskRemoved(Task task) {
        System.out.println("Task removed successfully.");
    }

    @Override
    public void onTaskUpdated(Task oldTask, Task updatedTask) {
        System.out.println("Task updated successfully.");
    }
}


