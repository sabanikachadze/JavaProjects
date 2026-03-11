package StudentGradeManagementSystem;

public abstract class AcademicEntity {
    private final String name;
    private final String id;

    public AcademicEntity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public abstract String getSummary();
}
