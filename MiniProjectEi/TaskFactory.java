import java.time.LocalTime;

public class TaskFactory {
    public Task createTask(String description, String startTimeStr, String endTimeStr, String priorityStr) {
        LocalTime start = Task.parseTime(startTimeStr);
        LocalTime end = Task.parseTime(endTimeStr);
        Priority priority = Priority.fromString(priorityStr);
        return new Task(description, start, end, priority);
    }
}


