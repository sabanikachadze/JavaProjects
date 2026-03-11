package StudentGradeManagementSystem;

import java.util.ArrayList;

public class Student  extends AcademicEntity{
    private final ArrayList<Course> enrolledCourses = new ArrayList<>();
    private final ArrayList<Double> grades = new ArrayList<>();

    public Student(String studentId, String name) {
        super(studentId,name);
    }

    public boolean enroll(Course c) throws AlreadyEnrolledException {
        for (Course course : enrolledCourses) {
            if (course.getId().equals(c.getId())) {
                throw new AlreadyEnrolledException("Course is already enrolled");
            }
        }
        enrolledCourses.add(c);
        grades.add(0.0);
        return true;
    }

    public boolean addGrade(Course c, double grade)
            throws CourseNotFoundException, InvalidGradeException {

        for (int i = 0; i < enrolledCourses.size(); i++) {
            Course course = enrolledCourses.get(i);

            if (course.getId().equals(c.getId())) {
                grades.set(i, course.checkGrade(grade));
                return true;
            }
        }

        throw new CourseNotFoundException("Couldn't find course");
    }


    public double getGPA() {
        double total = 0.0;
        for (double grade : grades) {
            total += grade;
        }
        if (enrolledCourses.isEmpty()) return 0.0;
        return total / enrolledCourses.size();
    }


    public String getTranscript() {
        StringBuilder sb = new StringBuilder();

        sb.append("================================\n");
        sb.append(String.format("Student: %-15s ID: %s%n", getName(), getId()));
        sb.append("================================\n");

        for (int i = 0; i < enrolledCourses.size(); i++) {
            Course c = enrolledCourses.get(i);
            double grade = grades.get(i);
            sb.append(String.format("%-8s %-20s %.1f%n",
                    c.getId(), c.getName(), grade));
        }

        sb.append("--------------------------------\n");
        sb.append(String.format("GPA: %.2f%n", getGPA()));

        return sb.toString();
    }

    @Override
    public String getSummary() {
        return String.format("Student [%s] %s | GPA=%.2f",
                getId(), getName(), getGPA());
    }
}
