package StudentMAnagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Student {
    private int id;
    String name;
    int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}

public class StudentManagementSystem {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public Optional<Student> getStudentById(int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst();
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public void updateStudent(int id, String name, int age) {
        getStudentById(id).ifPresent(student -> {
            student.name = name;
            student.age = age;
        });
    }

    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();

        system.addStudent(new Student(1, "Alice", 20));
        system.addStudent(new Student(2, "Bob", 22));
        system.addStudent(new Student(3, "Charlie", 21));

        System.out.println("All Students:");
        system.getAllStudents().forEach(System.out::println);

        int studentIdToUpdate = 2;
        system.updateStudent(studentIdToUpdate, "Bobby", 23);

        System.out.println("\nUpdated Student " + studentIdToUpdate + ":");
        System.out.println(system.getStudentById(studentIdToUpdate).orElse(null));

        int studentIdToDelete = 1;
        system.deleteStudent(studentIdToDelete);

        System.out.println("\nAll Students after deletion of Student " + studentIdToDelete + ":");
        system.getAllStudents().forEach(System.out::println);
    }
}
