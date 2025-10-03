# Astronaut Daily Schedule Organizer

A small, console-only Java app that helps an astronaut plan a day’s tasks. It focuses on clear code, SOLID design, and a few classic patterns (Singleton, Factory, Observer).

Why this exists: the brief asks for a simple terminal app that demonstrates sound design and handles the basics well: add/remove/view, validation, overlap checks, and friendly errors.

## Quick start
- Requires: Java 8+
- From PowerShell/Terminal in the project folder:
```bash
cd E:\MiniProjectEi
javac *.java
java Main
```

Tip: You can also compile to an output folder if you prefer:
```bash
javac -d out *.java
java -cp out Main
```

## What you can do
- Add a task: description, start time, end time, priority
- Remove a task by description
- View all tasks (sorted by start time)
- Edit an existing task
- Mark a task as completed
- Filter tasks by priority

Time formats accepted: `HH:mm` (24-hour) or `h:mm AM/PM` (12-hour). Priority is one of `High`, `Medium`, `Low` (case-insensitive).

## Sample session
```
Astronaut Daily Schedule Organizer
1. Add task
2. Remove task
3. View all tasks
4. Edit task
5. Mark task as completed
6. View tasks by priority
0. Exit

Choose an option: 1
Description: Morning Exercise
Start time (HH:mm or h:mm AM/PM): 7:00 AM
End time (HH:mm or h:mm AM/PM): 8:00 AM
Priority (High/Medium/Low): High
Task added successfully. No conflicts.

Choose an option: 1
Description: Team Meeting
Start time (HH:mm or h:mm AM/PM): 09:00
End time (HH:mm or h:mm AM/PM): 10:00
Priority (High/Medium/Low): Medium
Task added successfully. No conflicts.

Choose an option: 1
Description: Training Session
Start time (HH:mm or h:mm AM/PM): 09:30
End time (HH:mm or h:mm AM/PM): 10:30
Priority (High/Medium/Low): High
Error: Task conflicts with existing task "Team Meeting".

Choose an option: 3
07:00 - 08:00: Morning Exercise [High]
09:00 - 10:00: Team Meeting [Medium]
```

## Design at a glance
- Classes and responsibilities
  - `Task`: value object with validation (times, priority), completion flag, and overlap check
  - `ScheduleManager` (Singleton): single source of truth; add/remove/update/complete; conflict detection; view/filter
  - `TaskFactory`: builds validated `Task` instances from raw user input
  - `NotificationObserver` + `ConsoleNotifier` (Observer): surface conflicts and status updates to the user
  - `Main`: console menu and interaction loop; logs errors; delegates to `ScheduleManager`

- Patterns used
  - Singleton: `ScheduleManager.getInstance()` ensures a single manager for the session
  - Factory: `TaskFactory` centralizes validation and object creation
  - Observer: `NotificationObserver` decouples notifications from logic

- SOLID highlights
  - SRP: each class handles one concern (entity, creation, orchestration, notification)
  - OCP: behaviors can be extended (e.g., another observer) without modifying core logic
  - LSP/ISP: small, focused interface (`NotificationObserver`)
  - DIP: `ScheduleManager` depends on the `NotificationObserver` abstraction

- Error handling and logging
  - Friendly messages for invalid time, conflicts, and missing tasks
  - Java Util Logging (INFO/WARNING/SEVERE) for traceability

## Project layout
- `Main.java` (console UI + logging)
- `ScheduleManager.java` (singleton manager + conflict checks + CRUD)
- `Task.java` (entity)
- `TaskFactory.java` (creation/validation)
- `Priority.java` (enum)
- `NotificationObserver.java`, `ConsoleNotifier.java` (observer + console implementation)

## Notes
- In-memory, single-day schedule; no persistence by design (keeps the focus on logic)
- Conflict check is linear over tasks; list kept sorted for predictable display
- `.gitignore` excludes compiled artifacts like `*.class`

## Future ideas (optional)
- File-based persistence (Repository pattern) to save/load a day’s plan
- Unit tests (JUnit 5) for time parsing and overlap logic
- Configurable logging (file output)

This project is intentionally small and focused on correctness and clarity. Push it as-is or extend it with the ideas above if you want to showcase more.
