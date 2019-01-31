/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2019.
 */

package ru.digitalleague.demo.repository;

import ru.digitalleague.demo.domain.TaskEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository  extends CrudRepository<TaskEntity, Long> {

    List<TaskEntity> findAll();
    TaskEntity findByTaskId(int taskId);
    List<TaskEntity> findAllByTaskTitle(String taskTitle);
}
