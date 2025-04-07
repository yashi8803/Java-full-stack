package HealthProject.Eunoia.Service;

import HealthProject.Eunoia.Exceptions.ResourceNotFound;
import HealthProject.Eunoia.Repository.DoctorRepo;
import HealthProject.Eunoia.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServe {

    @Autowired
    private DoctorRepo doctorRepo;

    // Create a new doctor
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    // Get all doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }

    // Get doctor by ID
    public Doctor getDoctorById(long docId) {
        return doctorRepo.findById(docId)
                .orElseThrow(() -> new ResourceNotFound("Doctor not found with ID: " + docId));
    }

    // Update doctor details
    public Doctor updateDoctor(long docId, Doctor updatedDoctor) {
        Doctor existingDoctor = doctorRepo.findById(docId)
                .orElseThrow(() -> new ResourceNotFound("Doctor not found with ID: " + docId));

        if (updatedDoctor.getDocName() != null) {
            existingDoctor.setDocName(updatedDoctor.getDocName());
        }
        if (updatedDoctor.getDocDegree() != null) {
            existingDoctor.setDocDegree(updatedDoctor.getDocDegree());
        }
        if (updatedDoctor.getDocExp() != null) {
            existingDoctor.setDocExp(updatedDoctor.getDocExp());
        }
        if (updatedDoctor.getDocLang() != null) {
            existingDoctor.setDocLang(updatedDoctor.getDocLang());
        }
        if (updatedDoctor.getDocBio() != null) {
            existingDoctor.setDocBio(updatedDoctor.getDocBio());
        }
        if (updatedDoctor.getDocFees() != null) {
            existingDoctor.setDocFees(updatedDoctor.getDocFees());
        }
        if (updatedDoctor.getDocContact() != null) {
            existingDoctor.setDocContact(updatedDoctor.getDocContact());
        }
        if (updatedDoctor.getDocEmail() != null) {
            existingDoctor.setDocEmail(updatedDoctor.getDocEmail());
        }
        if (updatedDoctor.getDocAvai() != null) {
            existingDoctor.setDocAvai(updatedDoctor.getDocAvai());
        }
        if (updatedDoctor.getDocServices() != null) {
            existingDoctor.setDocServices(updatedDoctor.getDocServices());
        }

        return doctorRepo.save(existingDoctor);
    }


    // Delete doctor by ID
    public void deleteDoctor(long docId) {
        Doctor doctor = doctorRepo.findById(docId)
                .orElseThrow(() -> new ResourceNotFound("Doctor not found with ID: " + docId));
        doctorRepo.delete(doctor);
    }
}
