package Hospital;

public class Prescription {
    private Doctor doctor;
    private Patient patient;
    private String medication;
    private int dosage;

    private Prescription(Doctor doctor, Patient patient, String medication, int dosage) {
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
        this.dosage = dosage;
    }

    public static Prescription create(Doctor doctor, Patient patient,
                                      String medication, int dosage) {
        if (doctor == null || !doctor.isOnDuty()) return null;
        if (patient == null || !patient.isAdmitted()) return null;
        if (medication == null || medication.isEmpty()) return null;
        if (dosage <= 0) return null;
        return new Prescription(doctor, patient, medication, dosage);
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public int getDosage() {
        return dosage;
    }

    public String getMedication() {
        if(medication == null) return "wrong";
        return medication;
    }

    public Patient getPatient() {
        return patient;
    }

}