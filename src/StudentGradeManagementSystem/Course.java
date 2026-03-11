package StudentGradeManagementSystem;

public class Course extends AcademicEntity{
    private final double maxGrade;
    public Course(String courseCode, String courseName) {
        super(courseCode, courseName);
        this.maxGrade = 100.0;
    }

    @Override
    public String getSummary() {
        return String.format("Course [%s] %s | maxGrade=%.1f",
                getId(), getName(), maxGrade);
    }

    public double checkGrade(double grade) throws InvalidGradeException {
        if(grade < 0 || grade > maxGrade){
         throw new InvalidGradeException("Invalid Grade");}
         return grade;
    }
}
