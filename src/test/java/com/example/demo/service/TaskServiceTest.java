/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2018.
 */

package com.example.demo.service;


import com.example.demo.domain.TaskEntity;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.dto.TaskDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskServiceTest {

    @Autowired
    private TaskService taskService;

    @MockBean
    private TaskRepository taskRepo;


    @Test
    public void add() {
        TaskDTO task = new TaskDTO();
        task.setTaskTitle("New Task Title");
        task.setTaskText("This is task text");
        TaskEntity actual = taskService.add(task);

        Mockito.verify(taskRepo, Mockito.times(1)).save(actual);

        Assert.assertNotNull(actual);
    }

    @Test
    public void findTaskById() {
        TaskEntity task = new TaskEntity();
        task.setTaskId(1);
        task.setTaskTitle("Fake Task Title");

        Mockito.doReturn(task)
                .when(taskRepo)
                .findByTaskId(1);
        TaskEntity result = taskService.findTaskById(1);
        Assert.assertNotNull(result);
    }

    @Test
    public void findTaskByIdFail() {
        TaskEntity result = taskService.findTaskById(2);
        Mockito.verify(taskRepo, Mockito.times(1)).findByTaskId(2);
        Assert.assertNull(result);
    }
}