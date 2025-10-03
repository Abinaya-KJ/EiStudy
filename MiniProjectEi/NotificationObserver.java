public interface NotificationObserver {
    void onConflict(Task newTask, Task conflictingTask);
    void onTaskAdded(Task task);
    void onTaskRemoved(Task task);
    void onTaskUpdated(Task oldTask, Task updatedTask);
}


