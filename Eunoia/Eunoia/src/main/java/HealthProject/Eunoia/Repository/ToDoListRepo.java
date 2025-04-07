package HealthProject.Eunoia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import HealthProject.Eunoia.model.ToDoList;



@Repository
public interface ToDoListRepo extends JpaRepository<ToDoList, Long> {

}
