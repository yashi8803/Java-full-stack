package HealthProject.Eunoia.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HealthProject.Eunoia.Exceptions.ResourceNotFound;
import HealthProject.Eunoia.Repository.ToDoListRepo;
import HealthProject.Eunoia.Repository.ActivityRepo;
import HealthProject.Eunoia.model.ToDoList;
import HealthProject.Eunoia.model.Activity;

import java.util.List;

@Service
public class ToDoListServe {

    @Autowired
    private ToDoListRepo toDoListRepo;

    @Autowired
    private ActivityRepo activityRepo;

    // Create ToDoList and link it to an Activity
    public ToDoList addToDo(ToDoList toDoList, long activityId) {
        Activity activity = activityRepo.findById(activityId)
                .orElseThrow(() -> new ResourceNotFound("Activity not found with ID: " + activityId));

        ToDoList savedToDo = toDoListRepo.save(toDoList);

        activity.setToDoList(savedToDo); // updated method name
        activityRepo.save(activity);

        return savedToDo;
    }

    // Get all ToDoLists
    public List<ToDoList> getAllTasks() {
        return toDoListRepo.findAll();
    }

    // Get ToDoList by ID
    public ToDoList getTaskById(long taskId) {
        return toDoListRepo.findById(taskId)
                .orElseThrow(() -> new ResourceNotFound("Task not found with ID: " + taskId));
    }

    // Update ToDoList
    public ToDoList updateTask(long taskId, ToDoList updatedToDo) {
        ToDoList existing = getTaskById(taskId);

        if (updatedToDo.getTask() != null) {
            existing.setTask(updatedToDo.getTask());
        }
        if (updatedToDo.getDueDate() != null) {
            existing.setDueDate(updatedToDo.getDueDate());
        }

        return toDoListRepo.save(existing);
    }

    // Delete ToDoList
    public void deleteTask(long taskId) {
        ToDoList task = getTaskById(taskId);
        toDoListRepo.delete(task);
    }
}
