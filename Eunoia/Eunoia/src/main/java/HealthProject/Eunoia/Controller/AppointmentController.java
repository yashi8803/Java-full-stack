package HealthProject.Eunoia.Controller;

import HealthProject.Eunoia.Service.AppointmentServe;
import HealthProject.Eunoia.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/users/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentServe appointmentServe;
 
    // ✅ Create a new appointment with User ID and Doctor ID  //Done
    @PostMapping("/create/{userId}/{docId}")
    public ResponseEntity<Appointment> createAppointment(
            @PathVariable Long userId,
            @PathVariable Long docId,
            @RequestBody Appointment appointment) {

        Appointment newAppointment = appointmentServe.createAppointment(userId, docId, appointment);
        return ResponseEntity.ok(newAppointment);
    }

    // Get appointment by ID  //Done
    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable("id") long aptId) {
        Appointment appointment = appointmentServe.getAppointmentById(aptId);
        return ResponseEntity.ok(appointment);
    }

    // Get all appointments  //Done
    @GetMapping("/all")
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        List<Appointment> appointments = appointmentServe.getAllAppointments();
        return ResponseEntity.ok(appointments);
    }

    //Update an existing appointment (User ID and Doctor ID required)  //Done
    @PutMapping("/update/{id}/{userId}/{docId}")
    public ResponseEntity<Appointment> updateAppointment(
            @PathVariable("id") long aptId,
            @PathVariable("userId") long userId,
            @PathVariable("docId") long docId,
            @RequestBody Appointment updatedAppointment) {

        Appointment updated = appointmentServe.updateAppointment(aptId, userId, docId, updatedAppointment);
        return ResponseEntity.ok(updated);
    }

    // ✅ Delete an appointment
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable("id") long aptId) {
        appointmentServe.deleteAppointment(aptId);
        return ResponseEntity.noContent().build();
    }
}
