package Hospital;

public class Doctor {
    private final String name;
    private final String licenseId ;
     private final String specialization ;
    private boolean isOnDuty ;

    public Doctor(String name,String licenseId , String specialization) {
        this.name = name;
        this.licenseId = licenseId;
        this.specialization = specialization;
        isOnDuty = false;
    }
    public void setOnDuty(boolean duty){ isOnDuty = duty;}

    public boolean isOnDuty() {
        return isOnDuty;
    }

    public String getName() {
        return name;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public boolean treatPatient(Patient p, int amount){
        if(p == null) return false;
        if(p.isAdmitted() && isOnDuty){
            p.treat(amount);
            return true;
        }
        return false;
    }
}
