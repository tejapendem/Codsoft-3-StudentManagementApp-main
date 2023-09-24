import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManager {
    private List<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

public class StudentManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        int choice;
        do {
            System.out.println("Student's Management System Menu");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search for Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Update Student Information");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Roll Number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Grade: ");
                    String grade = scanner.nextLine();

                    if (!name.isEmpty() && !grade.isEmpty()) {
                        Student student = new Student(name, rollNumber, grade);
                        manager.addStudent(student);
                        System.out.println("Student added successfully!");
                    } else {
                        System.out.println("Error: Name and Grade cannot be empty.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Roll Number of the student to remove: ");
                    int rollToRemove = scanner.nextInt();
                    scanner.nextLine();
                    manager.removeStudent(rollToRemove);
                    System.out.println("Student removed successfully!");
                    break;

                case 3:
                    System.out.print("Enter Roll Number of the student to search: ");
                    int rollToSearch = scanner.nextInt();
                    scanner.nextLine();
                    Student searchedStudent = manager.searchStudent(rollToSearch);
                    if (searchedStudent != null) {
                        System.out.println("Student found: " + searchedStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    manager.displayAllStudents();
                    break;

                case 5:
                    System.out.print("Enter Roll Number of the student to update: ");
                    int rollToUpdate = scanner.nextInt();
                    scanner.nextLine();
                    Student studentToUpdate = manager.searchStudent(rollToUpdate);
                    if (studentToUpdate != null) {
                        System.out.println("Current Student Information: " + studentToUpdate);
                        System.out.print("Enter new Name (leave blank to keep the current name): ");
                        String newName = scanner.nextLine();
                        if (!newName.isEmpty()) {
                            studentToUpdate.setName(newName);
                        }

                        System.out.print("Enter new Grade (leave blank to keep the current grade): ");
                        String newGrade = scanner.nextLine();
                        if (!newGrade.isEmpty()) {
                            studentToUpdate.setGrade(newGrade);
                        }

                        System.out.println("Student information updated successfully!");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting the application.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
