package HealthProject.Eunoia.Controller;

import HealthProject.Eunoia.Service.ActivityServe;
import HealthProject.Eunoia.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController 
@RequestMapping("/users/activities")
public class ActivityController {

    @Autowired
    private ActivityServe activityServe;

    // ✅ Create a new activity
    @PostMapping("/create/{id}")
    public ResponseEntity<Activity> createActivity(
            @RequestBody Activity activity,
            @PathVariable("id") long userId) {
        Activity createdActivity = activityServe.createActivity(userId, activity);
        return ResponseEntity.ok(createdActivity);
    }

    // ✅ Get activity by ID
    @GetMapping("/{id}")
    public ResponseEntity<Activity> getActivityById(@PathVariable("id") long actId) {
        Activity activity = activityServe.getActivityById(actId);
        return ResponseEntity.ok(activity);
    }

    // ✅ Get all activities
    @GetMapping
    public ResponseEntity<List<Activity>> getAllActivities() {
        List<Activity> activities = activityServe.getAllActivities();
        return ResponseEntity.ok(activities);
    }

    // ✅ Update an existing activity (fixed)
    @PutMapping("/update/{id}")
    public ResponseEntity<Activity> updateActivity(
            @PathVariable("id") long actId,
            @RequestBody Activity updatedActivity) {
        Activity updated = activityServe.updateActivity(actId, updatedActivity);
        return ResponseEntity.ok(updated);
    }

    // ✅ Delete an activity
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteActivity(@PathVariable("id") long actId) {
        activityServe.deleteActivity(actId);
        return ResponseEntity.noContent().build();
    }
}
