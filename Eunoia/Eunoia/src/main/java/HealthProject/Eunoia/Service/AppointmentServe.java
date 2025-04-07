package HealthProject.Eunoia.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HealthProject.Eunoia.Exceptions.ResourceNotFound;
import HealthProject.Eunoia.Repository.AppointmentRepo;
import HealthProject.Eunoia.model.Appointment;
import HealthProject.Eunoia.model.Doctor;
import HealthProject.Eunoia.model.User;

import java.util.List;

@Service
public class AppointmentServe {
    
    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private UserServe userServe; // Inject UserServe to fetch user

    @Autowired
    private DoctorServe doctorServe;
    
    //Create Appointment with correct User & Doctor mapping
    public Appointment createAppointment(Long userId, Long docId, Appointment appointment) {
        User user = userServe.getUserById(userId);
        Doctor doctor = doctorServe.getDoctorById(docId);

        appointment.setUser(user);  // Set the User
        appointment.setDoctor(doctor); //Set the Doctor

        return appointmentRepo.save(appointment);
    }
    
    // Get Appointment by ID
    public Appointment getAppointmentById(long aptId) {
        return appointmentRepo.findById(aptId)
                .orElseThrow(() -> new ResourceNotFound("Appointment not found with ID: " + aptId));
    }
    
    // Get All Appointments
    public List<Appointment> getAllAppointments() {
        return appointmentRepo.findAll();
    }
    
 // Update Appointment (Ensuring Correct Mapping)
    public Appointment updateAppointment(long aptId, Long userId, Long docId, Appointment appointmentDetails) {
        // Fetch the existing appointment by its ID
        Appointment appointment = appointmentRepo.findById(aptId)
                .orElseThrow(() -> new ResourceNotFound("Appointment not found with ID: " + aptId));

        // Fetch the User and Doctor to ensure they exist
        User user = userServe.getUserById(userId);
        Doctor doctor = doctorServe.getDoctorById(docId);

        // Update appointment details
        appointment.setAptDate(appointmentDetails.getAptDate());
        appointment.setDocDetails(appointmentDetails.getDocDetails());
        appointment.setUser(user); 
        appointment.setDoctor(doctor);

        // Save and return the updated appointment
        return appointmentRepo.save(appointment);
    }

    
    // Delete Appointment
    public void deleteAppointment(long aptId) {
        Appointment appointment = getAppointmentById(aptId);
        appointmentRepo.delete(appointment);
    }
}
