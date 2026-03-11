package StudentGradeManagementSystem;

import java.util.ArrayList;

public class Department {
    private final String departmentName;
    private final ArrayList<Student> students = new ArrayList<>();

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public boolean addStudent(Student student) throws InvalidStudentException, AlreadyEnrolledException {
        if (student == null) throw new InvalidStudentException("Invalid student object");
        for (Student s : students) {
            if (student.getId().equals(s.getId())) {
                throw new InvalidStudentException("Student " + student.getId() + " already exists");
            }
        }
        students.add(student);
        return true;
    }

    public Student getTopStudent() {
        if (students.isEmpty()) return null;
        Student top = students.getFirst();
        for (Student student : students) {
            if (student.getGPA() > top.getGPA()) {
                top = student;
            }
        }
        return top;
    }

    public ArrayList<Student> getFailingStudents() {
        ArrayList<Student> failing = new ArrayList<>();
        for (Student student : students) {
            if (student.getGPA() < 60.0) failing.add(student);
        }
        return failing;
    }

    public void printDepartmentReport() {
        System.out.println("=== " + departmentName + " Department Report ===");
        for (Student student : students) {
            System.out.println(student.getTranscript());
            System.out.println("─────────────────────────────");
        }
        Student top = getTopStudent();
        System.out.println("Top Student: " + (top != null ? top.getName() : "No students yet"));
    }
}
