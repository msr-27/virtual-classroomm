package virtualclassroom;

import virtualclassroom.commands.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Virtual Classroom Manager");
        System.out.println("Available commands: add_classroom, add_student, schedule_assignment, submit_assignment, exit");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting application.");
                break;
            }

            String[] parts = input.split(" ", 4);
            if (parts.length < 1) {
                continue;
            }
            String commandName = parts;
            Command command = null;

            try {
                switch (commandName) {
                    case "add_classroom":
                        if (parts.length < 2) {
                            System.out.println("Usage: add_classroom <name>");
                        } else {
                            command = new AddClassroomCommand(parts);
                        }
                        break;
                    case "add_student":
                        if (parts.length < 3) {
                            System.out.println("Usage: add_student <id> <class_name>");
                        } else {
                            command = new AddStudentCommand(parts, parts);
                        }
                        break;
                    case "schedule_assignment":
                        if (parts.length < 3) {
                            System.out.println("Usage: schedule_assignment <class_name> <details>");
                        } else {
                            command = new ScheduleAssignmentCommand(parts, parts);
                        }
                        break;
                    case "submit_assignment":
                        if (parts.length < 4) {
                            System.out.println("Usage: submit_assignment <student_id> <class_name> <details>");
                        } else {
                            command = new SubmitAssignmentCommand(parts, parts, parts);
                        }
                        break;
                    default:
                        System.out.println("Unknown command: " + commandName);
                }

                if (command != null) {
                    command.execute();
                }
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
