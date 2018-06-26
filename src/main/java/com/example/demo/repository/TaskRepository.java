package com.example.demo.repository;

import com.example.demo.domain.TaskEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository  extends CrudRepository<TaskEntity, Long> {

    List<TaskEntity> findAll();
    TaskEntity findById(int id);
    List<TaskEntity> findAllByTaskTitle(String taskTitle);
}
