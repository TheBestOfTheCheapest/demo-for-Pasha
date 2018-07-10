package com.example.demo.repository;

import com.example.demo.domain.TaskEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository  extends CrudRepository<TaskEntity, Long> {

    List<TaskEntity> findAll();
    TaskEntity findByTaskId(int taskId);
    List<TaskEntity> findAllByTaskTitle(String taskTitle);
}
