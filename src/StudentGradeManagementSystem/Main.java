package StudentGradeManagementSystem;

public class Main {
    public static void main(String[] args) {
        try {
            // courses
            Course java    = new Course("CS101", "Intro to Java");
            Course math    = new Course("MA101", "Mathematics");
            Course english = new Course("EN101", "English");

            // students
            Student giorgi = new Student("STU-001", "Giorgi");
            Student nino   = new Student("STU-002", "Nino");
            Student luka   = new Student("STU-003", "Luka");

            // enroll
            giorgi.enroll(java);
            giorgi.enroll(math);
            nino.enroll(java);
            nino.enroll(english);
            luka.enroll(math);

            // grades
            giorgi.addGrade(java, 95);
            giorgi.addGrade(math, 88);
            nino.addGrade(java, 45);    // failing
            nino.addGrade(english, 50); // failing
            luka.addGrade(math, 72);

            // transcripts
            System.out.println(giorgi.getTranscript());
            System.out.println(nino.getTranscript());
            System.out.println(luka.getTranscript());

            // summaries
            System.out.println(giorgi.getSummary());
            System.out.println(java.getSummary());

            // department
            Department dept = new Department("Computer Science");
            dept.addStudent(giorgi);
            dept.addStudent(nino);
            dept.addStudent(luka);

            dept.printDepartmentReport();

            System.out.println("\n=== Failing Students ===");
            for (Student s : dept.getFailingStudents()) {
                System.out.println(s.getName() + " GPA: " + s.getGPA());
            }

            // test exceptions
            System.out.println("\n=== Exception Tests ===");

            // duplicate enrollment
            try {
                giorgi.enroll(java);
            } catch (AlreadyEnrolledException e) {
                System.out.println("Caught: " + e.getMessage());
            }

            // course not found
            try {
                giorgi.addGrade(english, 80);
            } catch (CourseNotFoundException e) {
                System.out.println("Caught: " + e.getMessage());
            }

            // invalid grade
            try {
                giorgi.addGrade(java, 150);
            } catch (InvalidGradeException e) {
                System.out.println("Caught: " + e.getMessage());
            }

        } catch (StudentExceptions e) {
            System.out.println(e.getMessage());
        }
    }
}