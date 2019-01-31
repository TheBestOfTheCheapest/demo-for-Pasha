/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2019.
 */

package com.example.demo.service;

import com.example.demo.domain.SolutionEntity;
import com.example.demo.domain.TaskEntity;
import com.example.demo.domain.UserEntity;
import com.example.demo.repository.SolutionRepository;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.core.SqlResolver;
import com.example.demo.service.core.TaskRunner;
import com.example.demo.service.dto.ResultDTO;
import com.example.demo.service.dto.TaskDTO;
import com.example.demo.service.dto.TasksDTO;
import com.example.demo.service.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepo;
    private final UserRepository userRepository;
    private final SolutionRepository solutionRepo;
    private final TaskMapper taskMapper;

    @Autowired
    public TaskService(TaskRepository taskRepo, UserRepository userRepository, SolutionRepository solutionRepo, TaskMapper taskMapper) {
        this.taskRepo = taskRepo;
        this.userRepository = userRepository;
        this.solutionRepo = solutionRepo;
        this.taskMapper = taskMapper;
    }

    public TasksDTO findAll() {
        TasksDTO tasks = new TasksDTO();
        List<TaskEntity> tasksList = taskRepo.findAll();
        tasks.setTasks(taskMapper.toDto(tasksList));
        return tasks;
    }

    public TasksDTO randomTasks(Integer number) throws Exception {
        if (number > taskRepo.count()) {
            throw new Exception("Too many tasks in Request");
        }
        TasksDTO tasks = new TasksDTO();
        List<TaskDTO> tasksList = new ArrayList<>();

        List<TaskEntity> tasksListE = taskRepo.findAll();
        Collections.shuffle(tasksListE);
        for (int i = 0; i < number; i++) {
            tasksList.add(taskMapper.toDto(tasksListE).get(i));
        }
        tasks.setTasks(tasksList);
        return tasks;
    }

    public TaskEntity findTaskById(int taskId) {
        return taskRepo.findByTaskId(taskId);
    }

    public TaskEntity add(TaskDTO taskDTO) {
        TaskEntity task = new TaskEntity();
        task.setTaskTitle(taskDTO.getTaskTitle());
        task.setTaskText(taskDTO.getTaskText());
        task.setSourceSample(taskDTO.getSourceSample());
        taskRepo.save(task);
        return task;
    }

    public ResultDTO getResult(SolutionEntity solution) {
        solution.setCreatedTime(LocalDateTime.now());
        TaskEntity task = taskRepo.findByTaskId(solution.getTask().getTaskId());
        ResultDTO result = new ResultDTO();
        if (task.getSectionEntity().getId() < 2 ) {
            TaskRunner taskRunner = new TaskRunner();

            try {
                //  result = taskRunner.run(Searcher.getSource("MatrixSumm"), solution.getSolutionValue(), taskTitle); //MatrixSumm как заглушка
                result.setResult(taskRunner.run(task.getSourceTemplate(), solution.getSolutionValue(), task.getTaskTitle()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                SqlResolver sr = new SqlResolver();
                result.setResult(sr.executeSql(solution.getSolutionValue()).toString());
            } catch (SQLException e) {
                e.printStackTrace();
            }


           /* try {




                int id = solution.getUser().getId();
                UserEntity user = userRepository.findById(id);
                 SqlResolver sr =new SqlResolver();
              //  SqlResolver sr = new SqlResolver((user.getEmail()).replace("@", "").replace(".", ""));
             //   sr.prepareTables(taskRepo.findByTaskId(solution.getTask().getTaskId()).getSourceTemplate());
                result.setResult(sr.executeSql(solution.getSolutionValue()).toString());
            } catch (SQLException e) {
                e.printStackTrace();
            }*/
        }
        solution.setTestResult(result.getResult());
        solutionRepo.save(solution);
        return result;
    }

    public void deleteTask(int taskId) {
        taskRepo.delete(findTaskById(taskId));
    }
}
