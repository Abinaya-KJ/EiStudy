import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;
import java.util.Locale;

public class Task implements Comparable<Task> {
	private static final DateTimeFormatter[] TIME_FORMATTERS = new DateTimeFormatter[] {
		DateTimeFormatter.ofPattern("HH:mm"),
		DateTimeFormatter.ofPattern("H:mm"),
		DateTimeFormatter.ofPattern("h:mm a", Locale.ENGLISH),
		DateTimeFormatter.ofPattern("hh:mm a", Locale.ENGLISH)
	};

	private final String description;
	private final LocalTime startTime;
	private final LocalTime endTime;
	private final Priority priority;
	private boolean completed;

	public Task(String description, LocalTime startTime, LocalTime endTime, Priority priority) {
		if (description == null || description.trim().isEmpty()) {
			throw new IllegalArgumentException("Description cannot be empty");
		}
		if (startTime == null || endTime == null) {
			throw new IllegalArgumentException("Start and End time cannot be null");
		}
		if (!endTime.isAfter(startTime)) {
			throw new IllegalArgumentException("End time must be after start time");
		}
		this.description = description.trim();
		this.startTime = startTime;
		this.endTime = endTime;
		this.priority = Objects.requireNonNull(priority, "Priority is required");
		this.completed = false;
	}

	public static LocalTime parseTime(String time) {
		for (DateTimeFormatter formatter : TIME_FORMATTERS) {
			try {
				return LocalTime.parse(time.trim().toUpperCase(Locale.ENGLISH), formatter);
			} catch (DateTimeParseException ignored) {
				// try next pattern
			}
		}
		throw new IllegalArgumentException("Error: Invalid time format. Use HH:mm (e.g., 07:00) or h:mm a (e.g., 7:00 AM)");
	}

	public String getDescription() {
		return description;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public Priority getPriority() {
		return priority;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void markCompleted() {
		this.completed = true;
	}

	public boolean overlaps(Task other) {
		return this.startTime.isBefore(other.endTime) && other.startTime.isBefore(this.endTime);
	}

	@Override
	public int compareTo(Task o) {
		return this.startTime.compareTo(o.startTime);
	}

	@Override
	public String toString() {
		String priorityStr = priority.name().substring(0, 1) + priority.name().substring(1).toLowerCase();
		return String.format("%s - %s: %s [%s]%s",
				startTime, endTime, description, priorityStr, completed ? " (Completed)" : "");
	}
}


