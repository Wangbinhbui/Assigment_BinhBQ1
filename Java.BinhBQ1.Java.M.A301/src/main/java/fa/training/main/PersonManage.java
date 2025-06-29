package fa.training.main;

import fa.training.entities.Person;
import fa.training.entities.Student;
import fa.training.entities.Teacher;
import fa.training.utils.Validator;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonManage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Input data");
            System.out.println("2. Update student");
            System.out.println("3. Display teachers with salary > $1000");
            System.out.println("4. Report students with final mark >= 6");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    inputData(scanner, people);
                    break;
                case 2:
                    updateStudent(scanner, people);
                    break;
                case 3:
                    displayHighSalaryTeachers(people);
                    break;
                case 4:
                    reportPassingStudents(people);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void inputData(Scanner scanner, ArrayList<Person> people) {
        System.out.println("Enter data for 10 people:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Person " + (i + 1) + ": (1 for Student, 2 for Teacher)");
            int type = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            System.out.print("Full Name: ");
            String fullName = scanner.nextLine();
            System.out.print("Gender: ");
            String gender = scanner.nextLine();
            System.out.print("Phone: ");
            String phone = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();

            // Validate email
            while (!Validator.isValidEmail(email)) {
                System.out.print("Invalid email! Enter again: ");
                email = scanner.nextLine();
            }

            if (type == 1) {
                System.out.print("Student ID: ");
                String studentId = scanner.nextLine();
                System.out.print("Theory score (0-10): ");
                double theory = scanner.nextDouble();
                while (!Validator.isValidScore(theory)) {
                    System.out.print("Invalid score! Enter again (0-10): ");
                    theory = scanner.nextDouble();
                }
                System.out.print("Practice score (0-10): ");
                double practice = scanner.nextDouble();
                while (!Validator.isValidScore(practice)) {
                    System.out.print("Invalid score! Enter again (0-10): ");
                    practice = scanner.nextDouble();
                }
                people.add(new Student(fullName, gender, phone, email, studentId, theory, practice));
            } else if (type == 2) {
                System.out.print("Basic Salary: ");
                double basicSalary = scanner.nextDouble();
                System.out.print("Subsidy: ");
                double subsidy = scanner.nextDouble();
                people.add(new Teacher(fullName, gender, phone, email, basicSalary, subsidy));
            }
            scanner.nextLine(); // Clear buffer
        }
    }

    private static void updateStudent(Scanner scanner, ArrayList<Person> people) {
        System.out.print("Enter Student ID to update: ");
        String studentId = scanner.nextLine();
        boolean found = false;

        for (Person person : people) {
            if (person instanceof Student && ((Student) person).getStudentId().equals(studentId)) {
                found = true;
                System.out.print("New Full Name: ");
                person.setFullName(scanner.nextLine());
                System.out.print("New Gender: ");
                person.setGender(scanner.nextLine());
                System.out.print("New Phone: ");
                person.setPhone(scanner.nextLine());
                System.out.print("New Email: ");
                String email = scanner.nextLine();
                while (!Validator.isValidEmail(email)) {
                    System.out.print("Invalid email! Enter again: ");
                    email = scanner.nextLine();
                }
                person.setEmail(email);
                System.out.print("New Theory score (0-10): ");
                double theory = scanner.nextDouble();
                while (!Validator.isValidScore(theory)) {
                    System.out.print("Invalid score! Enter again (0-10): ");
                    theory = scanner.nextDouble();
                }
                ((Student) person).setTheory(theory);
                System.out.print("New Practice score (0-10): ");
                double practice = scanner.nextDouble();
                while (!Validator.isValidScore(practice)) {
                    System.out.print("Invalid score! Enter again (0-10): ");
                    practice = scanner.nextDouble();
                }
                ((Student) person).setPractice(practice);
                System.out.println("Student updated successfully!");
                break;
            }
        }
        if (!found) {
            System.out.println("Student ID not found!");
        }
        scanner.nextLine(); // Clear buffer
    }

    private static void displayHighSalaryTeachers(ArrayList<Person> people) {
        boolean found = false;
        System.out.println("Teachers with salary > $1000:");
        for (Person person : people) {
            if (person instanceof Teacher && ((Teacher) person).calculateSalary() > 1000) {
                System.out.println(person);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No teachers with salary > $1000 found.");
        }
    }

    private static void reportPassingStudents(ArrayList<Person> people) {
        boolean found = false;
        System.out.println("Students with final mark >= 6:");
        for (Person person : people) {
            if (person instanceof Student && ((Student) person).calculateFinalMark() >= 6) {
                System.out.println(person);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students with final mark >= 6 found.");
        }
    }
}