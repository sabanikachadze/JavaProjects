package Hospital;

/**
 * TEST FILE — Do NOT modify.
 *
 * Run section by section as you implement each class.
 * Every comment shows exactly what should print.
 */
public class Main {

    public static void main(String[] args) {

        // ============================================================
        // SECTION 1 — Patient basics
        // ============================================================
        System.out.println("=== SECTION 1: Patient basics ===");

        Patient alice = new Patient("Alice", 1);
        System.out.println(alice.getName());        // Alice
        System.out.println(alice.getPatientId());   // 1
        System.out.println(alice.getHealthLevel()); // 50
        System.out.println(alice.isAdmitted());     // false

        // treat does nothing when not admitted
        alice.treat(20);
        System.out.println(alice.getHealthLevel()); // 50 — unchanged

        // admit then treat
        alice.admit();
        System.out.println(alice.isAdmitted());     // true
        alice.treat(20);
        System.out.println(alice.getHealthLevel()); // 70

        // treat never exceeds 100
        alice.treat(50);
        System.out.println(alice.getHealthLevel()); // 100 — capped

        // negative/zero treat does nothing
        alice.treat(-10);
        alice.treat(0);
        System.out.println(alice.getHealthLevel()); // 100 — unchanged

        // discharge
        alice.discharge();
        System.out.println(alice.isAdmitted());     // false

        // discharge again does nothing
        alice.discharge();
        System.out.println(alice.isAdmitted());     // false

        // admit again does nothing if already admitted
        alice.admit();
        alice.admit();
        System.out.println(alice.isAdmitted());     // true

        // constructor validation
        Patient unknown = new Patient(null, 99);
        System.out.println(unknown.getName());      // Unknown Patient

        Patient unknown2 = new Patient("   ", 98);
        System.out.println(unknown2.getName());     // Unknown Patient

        // ============================================================
        // SECTION 2 — Doctor basics
        // ============================================================
        System.out.println("\n=== SECTION 2: Doctor basics ===");

        Doctor drSmith = new Doctor("Dr Smith", "LIC001", "Cardiology");
        System.out.println(drSmith.getName());           // Dr Smith
        System.out.println(drSmith.getLicenseId());      // LIC001
        System.out.println(drSmith.getSpecialization()); // Cardiology
        System.out.println(drSmith.isOnDuty());          // false

        Patient bob = new Patient("Bob", 2);
        bob.admit();

        // doctor not on duty — treatPatient fails
        System.out.println(drSmith.treatPatient(bob, 20)); // false
        System.out.println(bob.getHealthLevel());           // 50 — unchanged

        // put doctor on duty
        drSmith.setOnDuty(true);
        System.out.println(drSmith.treatPatient(bob, 20)); // true
        System.out.println(bob.getHealthLevel());           // 70

        // patient not admitted — fails
        Patient notAdmitted = new Patient("Charlie", 3);
        System.out.println(drSmith.treatPatient(notAdmitted, 20)); // false

        // null patient — fails
        System.out.println(drSmith.treatPatient(null, 20)); // false

        // doctor constructor validation
        Doctor badDoctor = new Doctor(null, "", null);
        System.out.println(badDoctor.getName());           // Unknown
        System.out.println(badDoctor.getLicenseId());      // Unknown
        System.out.println(badDoctor.getSpecialization()); // Unknown

        // ============================================================
        // SECTION 3 — Prescription factory
        // ============================================================
        System.out.println("\n=== SECTION 3: Prescription factory ===");

        Doctor drJones = new Doctor("Dr Jones", "LIC002", "Neurology");
        Patient dave = new Patient("Dave", 4);

        // doctor not on duty → null
        Prescription p1 = Prescription.create(drJones, dave, "Aspirin", 100);
        System.out.println(p1); // null

        drJones.setOnDuty(true);

        // patient not admitted → null
        Prescription p2 = Prescription.create(drJones, dave, "Aspirin", 100);
        System.out.println(p2); // null

        dave.admit();

        // null medication → null
        Prescription p3 = Prescription.create(drJones, dave, null, 100);
        System.out.println(p3); // null

        // blank medication → null
        Prescription p4 = Prescription.create(drJones, dave, "   ", 100);
        System.out.println(p4); // null

        // zero dosage → null
        Prescription p5 = Prescription.create(drJones, dave, "Aspirin", 0);
        System.out.println(p5); // null

        // negative dosage → null
        Prescription p6 = Prescription.create(drJones, dave, "Aspirin", -5);
        System.out.println(p6); // null

        // null doctor → null
        Prescription p7 = Prescription.create(null, dave, "Aspirin", 100);
        System.out.println(p7); // null

        // null patient → null
        Prescription p8 = Prescription.create(drJones, null, "Aspirin", 100);
        System.out.println(p8); // null

        // valid prescription
        Prescription valid = Prescription.create(drJones, dave, "Aspirin", 100);
        System.out.println(valid == null);                    // false
        System.out.println(valid.getMedication());            // Aspirin
        System.out.println(valid.getDosage());                // 100
        System.out.println(valid.getDoctor().getName());      // Dr Jones
        System.out.println(valid.getPatient().getName());     // Dave

        // ============================================================
        // SECTION 4 — Hospital: admit and discharge
        // ============================================================
        System.out.println("\n=== SECTION 4: Hospital admit and discharge ===");

        Hospital hospital = new Hospital("City Hospital", 3);

        Patient p_alice = new Patient("Alice", 10);
        Patient p_bob   = new Patient("Bob",   11);
        Patient p_carol = new Patient("Carol", 12);
        Patient p_dan   = new Patient("Dan",   13);

        System.out.println(hospital.admitPatient(p_alice)); // true
        System.out.println(hospital.admitPatient(p_bob));   // true
        System.out.println(hospital.admitPatient(p_carol)); // true
        System.out.println(hospital.admitPatient(p_dan));   // false — hospital full

        System.out.println(p_alice.isAdmitted()); // true
        System.out.println(p_dan.isAdmitted());   // false

        // admit null → false
        System.out.println(hospital.admitPatient(null)); // false

        // admit already admitted → false
        System.out.println(hospital.admitPatient(p_alice)); // false

        // discharge
        System.out.println(hospital.dischargePatient(p_bob));  // true
        System.out.println(p_bob.isAdmitted());                // false

        // now there's room
        System.out.println(hospital.admitPatient(p_dan));  // true
        System.out.println(p_dan.isAdmitted());            // true

        // discharge not-admitted patient
        System.out.println(hospital.dischargePatient(p_bob)); // false — already discharged

        // discharge null
        System.out.println(hospital.dischargePatient(null)); // false

        // ============================================================
        // SECTION 5 — Hospital: averageHealthLevel and findPatientById
        // ============================================================
        System.out.println("\n=== SECTION 5: Average health and find by id ===");

        Hospital h2 = new Hospital("General Hospital", 5);
        Patient pa = new Patient("Anna",  20);
        Patient pb = new Patient("Ben",   21);
        Patient pc = new Patient("Clara", 22);

        // no patients → 0.0
        System.out.println(h2.getAverageHealthLevel()); // 0.0

        h2.admitPatient(pa);
        h2.admitPatient(pb);
        h2.admitPatient(pc);

        // all start at 50 → average 50.0
        System.out.println(h2.getAverageHealthLevel()); // 50.0

        // treat pa (needs a doctor on duty)
        Doctor drAva = new Doctor("Dr Ava", "LIC010", "General");
        drAva.setOnDuty(true);
        drAva.treatPatient(pa, 30); // pa health → 80

        System.out.println(h2.getAverageHealthLevel()); // (80+50+50)/3 = 60.0

        // discharge pb — average recalculates only admitted patients
        h2.dischargePatient(pb);
        System.out.println(h2.getAverageHealthLevel()); // (80+50)/2 = 65.0

        // findPatientById
        System.out.println(h2.findPatientById(20).getName()); // Anna
        System.out.println(h2.findPatientById(22).getName()); // Clara
        System.out.println(h2.findPatientById(21));           // null — discharged
        System.out.println(h2.findPatientById(999));          // null — never existed

        // ============================================================
        // SECTION 6 — Hospital: doctors on duty
        // ============================================================
        System.out.println("\n=== SECTION 6: Doctors on duty ===");

        Hospital h3 = new Hospital("St Mary's", 10);
        Doctor d1 = new Doctor("Dr One",   "L1", "Surgery");
        Doctor d2 = new Doctor("Dr Two",   "L2", "Cardiology");
        Doctor d3 = new Doctor("Dr Three", "L3", "Pediatrics");

        h3.registerDoctor(d1);
        h3.registerDoctor(d2);
        h3.registerDoctor(d3);

        // none on duty yet
        System.out.println(h3.getDoctorsOnDuty().length); // 0

        d1.setOnDuty(true);
        System.out.println(h3.getDoctorsOnDuty().length);        // 1
        System.out.println(h3.getDoctorsOnDuty()[0].getName());  // Dr One

        d3.setOnDuty(true);
        System.out.println(h3.getDoctorsOnDuty().length); // 2

        d1.setOnDuty(false);
        System.out.println(h3.getDoctorsOnDuty().length); // 1

        // register null → false
        System.out.println(h3.registerDoctor(null)); // false

        // defensive copy of getDoctorsOnDuty
        Doctor[] onDuty = h3.getDoctorsOnDuty();
        onDuty[0] = null;
        System.out.println(h3.getDoctorsOnDuty()[0].getName()); // Dr Three — not corrupted

        // ============================================================
        // SECTION 7 — Prescriptions in hospital
        // ============================================================
        System.out.println("\n=== SECTION 7: Prescriptions ===");

        Hospital h4 = new Hospital("Riverside", 10);
        Doctor drX = new Doctor("Dr X", "LX1", "General");
        Doctor drY = new Doctor("Dr Y", "LY1", "General");
        Patient px = new Patient("Xena", 30);
        Patient py = new Patient("Yara", 31);

        h4.registerDoctor(drX);
        h4.registerDoctor(drY);
        h4.admitPatient(px);
        h4.admitPatient(py);

        drX.setOnDuty(true);
        drY.setOnDuty(true);

        Prescription rx1 = Prescription.create(drX, px, "Ibuprofen", 200);
        Prescription rx2 = Prescription.create(drX, px, "Paracetamol", 500);
        Prescription ry1 = Prescription.create(drY, py, "Amoxicillin", 250);

        h4.addPrescription(rx1);
        h4.addPrescription(rx2);
        h4.addPrescription(ry1);
        h4.addPrescription(null); // ignored

        // prescriptions for px
        Prescription[] xPrescriptions = h4.getPrescriptionsForPatient(px);
        System.out.println(xPrescriptions.length);              // 2
        System.out.println(xPrescriptions[0].getMedication());  // Ibuprofen
        System.out.println(xPrescriptions[1].getMedication());  // Paracetamol

        // prescriptions for py
        Prescription[] yPrescriptions = h4.getPrescriptionsForPatient(py);
        System.out.println(yPrescriptions.length);              // 1
        System.out.println(yPrescriptions[0].getMedication());  // Amoxicillin

        // prescriptions for someone with none
        Patient pz = new Patient("Zara", 32);
        h4.admitPatient(pz);
        System.out.println(h4.getPrescriptionsForPatient(pz).length); // 0

        // ============================================================
        // SECTION 8 — Full scenario (everything together)
        // ============================================================
        System.out.println("\n=== SECTION 8: Full scenario ===");

        Hospital main = new Hospital("Main Hospital", 4);

        Patient s1 = new Patient("Sara",  40);
        Patient s2 = new Patient("Tom",   41);
        Patient s3 = new Patient("Uma",   42);

        Doctor specialist = new Doctor("Dr Lee", "LEE01", "Oncology");
        main.registerDoctor(specialist);
        specialist.setOnDuty(true);

        main.admitPatient(s1);
        main.admitPatient(s2);
        main.admitPatient(s3);

        System.out.println(main.getAverageHealthLevel()); // 50.0

        specialist.treatPatient(s1, 40); // s1 → 90
        specialist.treatPatient(s2, 10); // s2 → 60
        // s3 untreated → 50

        System.out.println(main.getAverageHealthLevel()); // (90+60+50)/3 = 66.666...

        Prescription medS1 = Prescription.create(specialist, s1, "Morphine", 10);
        Prescription medS2 = Prescription.create(specialist, s2, "Codeine", 30);
        main.addPrescription(medS1);
        main.addPrescription(medS2);

        // discharge s2
        main.dischargePatient(s2);
        System.out.println(main.getAverageHealthLevel()); // (90+50)/2 = 70.0

        // s2 prescription still retrievable (prescriptions don't disappear on discharge)
        System.out.println(main.getPrescriptionsForPatient(s2).length); // 1

        // find admitted patients
        System.out.println(main.findPatientById(40).getName()); // Sara
        System.out.println(main.findPatientById(41));           // null — discharged

        System.out.println("\n=== ALL DONE ===");
    }
}
