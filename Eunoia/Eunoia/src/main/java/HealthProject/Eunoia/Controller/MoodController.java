package HealthProject.Eunoia.Controller;

import HealthProject.Eunoia.Service.MoodServe;
import HealthProject.Eunoia.model.Mood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController 
@RequestMapping("/users/moods")
public class MoodController {

    @Autowired
    private MoodServe moodServe;

    // Add a new mood entry  //Done
    @PostMapping("/create/{id}")
    public ResponseEntity<Mood> addMood(@RequestBody Mood mood, @PathVariable("id") long userId) {
        Mood createdMood = moodServe.addMood(userId, mood); // Pass userId!
        return ResponseEntity.ok(createdMood);
    }

    // Get all mood entries  //Done
    @GetMapping
    public ResponseEntity<List<Mood>> getAllMoods() {
        List<Mood> moods = moodServe.getAllMoods();
        return ResponseEntity.ok(moods);
    }

    // Get mood entry by ID  //Done
    @GetMapping("/{id}")
    public ResponseEntity<Mood> getMoodById(@PathVariable("id") long moodId) {
        Mood mood = moodServe.getMoodById(moodId);
        return ResponseEntity.ok(mood);
    }

   
    // Update an existing mood entry   //Done
    @PutMapping("update/{id}/{userId}")
    public ResponseEntity<Mood> updateMood( @RequestBody Mood moodDetails, @PathVariable("id") long moodId, @PathVariable("userId") long userId) {
        Mood updatedMood = moodServe.updateMood(moodId, moodDetails);
        return ResponseEntity.ok(updatedMood);
    }

    // Delete a mood entry   //Done
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMood(@PathVariable("id") long moodId) {
        moodServe.deleteMood(moodId);
        return ResponseEntity.noContent().build();
    }
}
