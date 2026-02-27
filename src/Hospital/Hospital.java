package Hospital;

import java.util.Arrays;

public class Hospital {
    private final String name;
    private final int capacity;
    private int countPatients;
    private final Patient[] patients ;
    private int  doctorCount;
    private final Doctor[] doctors = new Doctor[20];
    private int prescriptionCount;
    private final Prescription[] prescriptions = new Prescription[100];

    public Hospital(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.patients = new Patient[capacity];
        this.countPatients = 0;
        this.doctorCount = 0;
        this.prescriptionCount = 0;
    }
    public void addPrescription(Prescription p) {
        if (prescriptionCount < prescriptions.length) {
            prescriptions[prescriptionCount++] = p;
        } else {
            System.out.println("Cannot add more prescriptions, array is full.");
        }
    }

    public boolean admitPatient(Patient p){
        if(p == null || p.isAdmitted() || countPatients >= capacity){
            return false;
        }
        patients[countPatients++] = p;
        p.admit();
        return true;
    }
        public boolean registerDoctor(Doctor d){
        if(d == null || d.isOnDuty() || countPatients >= capacity){
            return false;
        }
        doctors[doctorCount++] = d;
        d.setOnDuty(true);
        return true;
    }
    public boolean dischargePatient(Patient p){
        boolean patientFound = false;
        for(int i = 0; i < countPatients; i++){
            if(patients[i].equals(p)){
                patientFound = true;
                p.discharge();
            }else if(patientFound){
                patients[i - 1] = patients[i];
            }
        }
        countPatients--;
        return patientFound;
    }

    public Doctor[] getDoctorsOnDuty() {
        return Arrays.copyOf(doctors, doctorCount);
    }
    public double getAverageHealthLevel(){
        if(countPatients == 0) return 0;
        int count = 0;
        double total = 0.0;
        for(int i = 0; i < countPatients; i ++){
          count++;
          total += patients[i].getHealthLevel();
        }
        return total / count;
    }
    public Patient findPatientById(int id){
        for(int i = 0; i < countPatients; i++){
            if(patients[i].getPatientId() == id) return patients[i];
        }
        return null;
    }

    public Prescription[] getPrescriptionsForPatient(Patient p) {
        Prescription[] temp = new Prescription[prescriptionCount];
        int count = 0;

        for (int i = 0; i < prescriptionCount; i++) {
            if (prescriptions[i] != null && prescriptions[i].getPatient().equals(p)) {
                temp[count++] = prescriptions[i];
            }
        }

        return Arrays.copyOf(temp, count);
    }
}
