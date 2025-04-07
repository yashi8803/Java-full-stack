package HealthProject.Eunoia.Controller;

import HealthProject.Eunoia.Service.ToDoListServe;
import HealthProject.Eunoia.model.ToDoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/users/tasks")
public class ToDoListController {

    @Autowired
    private ToDoListServe toDoListServe;

    // ✅ Create task based on Activity ID only (no direct user relation)
    @PostMapping("/create/{activityId}")
    public ResponseEntity<ToDoList> createTask(
            @RequestBody ToDoList task,
            @PathVariable("activityId") long activityId) {
        ToDoList createdTask = toDoListServe.addToDo(task, activityId);
        return ResponseEntity.ok(createdTask);
    }

    // ✅ Get all tasks
    @GetMapping
    public ResponseEntity<List<ToDoList>> getAllTasks() {
        List<ToDoList> tasks = toDoListServe.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    // ✅ Get task by ID
    @GetMapping("/{id}")
    public ResponseEntity<ToDoList> getTaskById(@PathVariable("id") long taskId) {
        ToDoList task = toDoListServe.getTaskById(taskId);
        return ResponseEntity.ok(task);
    }

    // ✅ Update task by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<ToDoList> updateTask(
            @PathVariable("id") long taskId,
            @RequestBody ToDoList taskDetails) {
        ToDoList updatedTask = toDoListServe.updateTask(taskId, taskDetails);
        return ResponseEntity.ok(updatedTask);
    }

    // ✅ Delete task by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("id") long taskId) {
        toDoListServe.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }
}
