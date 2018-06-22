package com.example.demo.repository;

import com.example.demo.domain.TaskEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository  extends CrudRepository<TaskEntity, Long> {

    TaskEntity findById(int id);
    List<TaskEntity> findAllByName(String name);
}
