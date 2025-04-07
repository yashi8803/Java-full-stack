package HealthProject.Eunoia.Service;

import HealthProject.Eunoia.Exceptions.ResourceNotFound;
import HealthProject.Eunoia.Repository.ActivityRepo;
import HealthProject.Eunoia.Repository.UserRepository;
import HealthProject.Eunoia.model.Activity;
import HealthProject.Eunoia.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServe {

    @Autowired
    private ActivityRepo activityRepo;

    @Autowired
    private UserRepository userRepo;

    // Create new activity
    public Activity createActivity(Long userId, Activity activity) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFound("User not found with ID: " + userId));
        activity.setUser(user);
        return activityRepo.save(activity);
    }

    // Get activity by ID
    public Activity getActivityById(Long activityId) {
        return activityRepo.findById(activityId)
                .orElseThrow(() -> new ResourceNotFound("Activity not found with ID: " + activityId));
    }

    // Get all activities
    public List<Activity> getAllActivities() {
        return activityRepo.findAll();
    }

    // Update activity
    public Activity updateActivity(Long activityId, Activity updatedActivity) {
        Activity existingActivity = getActivityById(activityId);
        existingActivity.setToDoList(updatedActivity.getToDoList());
        existingActivity.setAssessmentResult(updatedActivity.getAssessmentResult());
        existingActivity.setGameScore(updatedActivity.getGameScore());
        return activityRepo.save(existingActivity);
    }

    // Delete activity
    public void deleteActivity(Long activityId) {
        Activity existingActivity = getActivityById(activityId);
        activityRepo.delete(existingActivity);
    }
}
