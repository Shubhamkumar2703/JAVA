import java.io.*;
import java.util.*;

// Student class
class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private int rollNo;
    private String name;
    private String course;

    public Student(int rollNo, String name, String course) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name + ", Course: " + course;
    }
}

// Main class
public class StudentManagementSystem {
    private static final String FILE_NAME = "students.dat";
    private ArrayList<Student> students;

    public StudentManagementSystem() {
        students = loadData();
    }

    // Add Student
    public void addStudent(Scanner sc) {
        System.out.print("Enter Roll No: ");
        int rollNo = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        students.add(new Student(rollNo, name, course));
        System.out.println("✅ Student added successfully!");
    }

    // View All Students
    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        students.forEach(System.out::println);
    }

    // Search Student
    public void searchStudent(Scanner sc) {
        System.out.print("Enter Roll No to search: ");
        int rollNo = sc.nextInt();
        for (Student s : students) {
            if (s.getRollNo() == rollNo) {
                System.out.println("Student Found: " + s);
                return;
            }
        }
        System.out.println("❌ Student not found.");
    }

    // Remove Student
    public void removeStudent(Scanner sc) {
        System.out.print("Enter Roll No to remove: ");
        int rollNo = sc.nextInt();
        Iterator<Student> itr = students.iterator();
        while (itr.hasNext()) {
            if (itr.next().getRollNo() == rollNo) {
                itr.remove();
                System.out.println("✅ Student removed successfully!");
                return;
            }
        }
        System.out.println("❌ Student not found.");
    }

    // Save Data
    public void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
            System.out.println("💾 Data saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Load Data
    @SuppressWarnings("unchecked")
    public ArrayList<Student> loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ArrayList<Student>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>(); // no file yet
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Menu
    public void start() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Save & Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addStudent(sc);
                case 2 -> viewStudents();
                case 3 -> searchStudent(sc);
                case 4 -> removeStudent(sc);
                case 5 -> {
                    saveData();
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.start();
    }
}
