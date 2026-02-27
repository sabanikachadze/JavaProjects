package Hospital;

public class Patient {
    private final String name;
    private final int patientId;
    private int healthLevel = 50;
    private boolean isAdmitted;

    public Patient(String name, int patientId) {
        this.name = name;
        this.patientId = patientId;
        isAdmitted = false;
    }

    public String getName() {
        return name;
    }

    public void treat(int amount) {
        if(!isAdmitted) return;

        if(healthLevel + amount <= 100){
             healthLevel += amount;
        }
       healthLevel = 100;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getHealthLevel() {
        return healthLevel;
    }

    public boolean isAdmitted() {
        return isAdmitted;
    }

    public void discharge() {
        if (isAdmitted) isAdmitted = false;
    }

    public void admit() {
        if (!isAdmitted) isAdmitted = true;
    }
}
