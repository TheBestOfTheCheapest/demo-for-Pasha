package com.example.demo.repository;

import com.example.demo.entity.TaskEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository  extends CrudRepository<TaskEntity, Long> {

    List<TaskEntity> findById(Integer id);
    List<TaskEntity> findAllByName(String name);
}
