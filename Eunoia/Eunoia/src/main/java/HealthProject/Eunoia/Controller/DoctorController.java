package HealthProject.Eunoia.Controller;

import HealthProject.Eunoia.Service.DoctorServe;
import HealthProject.Eunoia.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorServe doctorServe;

    // Create a new doctor  //Done
    @PostMapping("/create")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        Doctor createdDoctor = doctorServe.addDoctor(doctor);
        return ResponseEntity.ok(createdDoctor);
    }

    // Get all doctors 	//Done
    @GetMapping("/all")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = doctorServe.getAllDoctors();
        return ResponseEntity.ok(doctors);
    }

    // Get doctor by ID		//Done
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable("id") long docId) {
        Doctor doctor = doctorServe.getDoctorById(docId);
        return ResponseEntity.ok(doctor);
    }

    // Update doctor details
    @PutMapping("/update/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable("id") long docId, @RequestBody Doctor updatedDoctor) {
        Doctor doctor = doctorServe.updateDoctor(docId, updatedDoctor);
        return ResponseEntity.ok(doctor);
    }

    // Delete doctor by ID  //Done
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable("id") long docId) {
        doctorServe.deleteDoctor(docId);
        return ResponseEntity.ok("Doctor deleted successfully");
    }

}
