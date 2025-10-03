import java.util.List;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
	private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {
		configureLogging();
		ScheduleManager manager = ScheduleManager.getInstance();
		manager.addObserver(new ConsoleNotifier());

		TaskFactory factory = new TaskFactory();
		Scanner scanner = new Scanner(System.in);
		boolean running = true;

		while (running) {
			printMenu();
			System.out.print("Choose an option: ");
			String choice = scanner.nextLine();

			try {
				switch (choice) {
					case "1":
						System.out.print("Description: ");
						String desc = scanner.nextLine();
						System.out.print("Start time (HH:mm or h:mm AM/PM): ");
						String start = scanner.nextLine();
						System.out.print("End time (HH:mm or h:mm AM/PM): ");
						String end = scanner.nextLine();
						System.out.print("Priority (High/Medium/Low): ");
						String pr = scanner.nextLine();
						Task task = factory.createTask(desc, start, end, pr);
						boolean added = manager.addTask(task);
						if (!added) {
							// observer prints conflict
						}
						break;
					case "2":
						System.out.print("Description to remove: ");
						String toRemove = scanner.nextLine();
						if (!manager.removeTask(toRemove)) {
							System.out.println("Error: Task not found.");
						}
						break;
					case "3":
						List<Task> tasks = manager.viewAll();
						if (tasks.isEmpty()) {
							System.out.println("No tasks scheduled for the day.");
						} else {
							for (Task t : tasks) {
								System.out.println(t.toString());
							}
						}
						break;
					case "4":
						System.out.print("Description to edit: ");
						String toEdit = scanner.nextLine();
						System.out.print("New description: ");
						String newDesc = scanner.nextLine();
						System.out.print("New start time (HH:mm or h:mm AM/PM): ");
						String newStart = scanner.nextLine();
						System.out.print("New end time (HH:mm or h:mm AM/PM): ");
						String newEnd = scanner.nextLine();
						System.out.print("New priority (High/Medium/Low): ");
						String newPr = scanner.nextLine();
						Task updated = factory.createTask(newDesc, newStart, newEnd, newPr);
						if (!manager.updateTask(toEdit, updated)) {
							// conflict or not found handled with messages
							System.out.println("Error: Update failed (not found or conflict).");
						}
						break;
					case "5":
						System.out.print("Description to mark complete: ");
						String toComplete = scanner.nextLine();
						if (!manager.markCompleted(toComplete)) {
							System.out.println("Error: Task not found.");
						} else {
							System.out.println("Task marked as completed.");
						}
						break;
					case "6":
						System.out.print("Priority to view (High/Medium/Low): ");
						String viewPr = scanner.nextLine();
						List<Task> filtered = manager.viewByPriority(Priority.fromString(viewPr));
						if (filtered.isEmpty()) {
							System.out.println("No tasks found for the selected priority.");
						} else {
							for (Task t : filtered) {
								System.out.println(t.toString());
							}
						}
						break;
					case "0":
						running = false;
						System.out.println("Goodbye!");
						break;
					default:
						System.out.println("Invalid option. Try again.");
				}
			} catch (IllegalArgumentException ex) {
				System.out.println(ex.getMessage());
				LOGGER.log(Level.WARNING, "Invalid operation: {0}", ex.getMessage());
			} catch (Exception ex) {
				System.out.println("An error occurred. Please try again.");
				LOGGER.log(Level.SEVERE, "Unexpected error", ex);
			}
		}
	}

	private static void configureLogging() {
		Logger root = Logger.getLogger("");
		ConsoleHandler handler = new ConsoleHandler();
		handler.setLevel(Level.INFO);
		root.addHandler(handler);
		root.setLevel(Level.INFO);
	}

	private static void printMenu() {
		System.out.println();
		System.out.println("Astronaut Daily Schedule Organizer");
		System.out.println("1. Add task");
		System.out.println("2. Remove task");
		System.out.println("3. View all tasks");
		System.out.println("4. Edit task");
		System.out.println("5. Mark task as completed");
		System.out.println("6. View tasks by priority");
		System.out.println("0. Exit");
	}
}


