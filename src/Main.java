import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradeManager gradeManager = new GradeManager();

        while (true) {
            System.out.println("Student Grade Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by Name");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Add student
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter grade: ");
                    double grade = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline

                    Student student = new Student(name, id, grade);
                    gradeManager.addStudent(student);
                    break;

                case 2:
                    // Display all students from the database
                    System.out.println("Students in database:");
                    for (Student s : gradeManager.getAllStudents()) {
                        System.out.println(s);
                    }
                    break;

                case 3:
                    // Search student by name
                    System.out.print("Enter student name: ");
                    String searchName = scanner.nextLine();
                    Student foundStudent = gradeManager.searchStudentByName(searchName);
                    if (foundStudent != null) {
                        System.out.println("Student found: " + foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    // Exit the program
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
