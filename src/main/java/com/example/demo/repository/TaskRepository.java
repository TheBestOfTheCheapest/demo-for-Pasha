package com.example.demo.repository;

import com.example.demo.entity.TaskEntity;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository  extends CrudRepository<TaskEntity, Long> {
}
