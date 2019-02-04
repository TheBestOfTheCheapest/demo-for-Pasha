/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2019.
 */

package ru.digitalleague.demo.service;

import ru.digitalleague.demo.domain.SolutionEntity;
import ru.digitalleague.demo.domain.TaskEntity;
import ru.digitalleague.demo.repository.SolutionRepository;
import ru.digitalleague.demo.repository.TaskRepository;
import ru.digitalleague.demo.service.core.TaskRunner;
import ru.digitalleague.demo.service.dto.ResultDTO;
import ru.digitalleague.demo.service.dto.TaskDTO;
import ru.digitalleague.demo.service.dto.TasksDTO;
import ru.digitalleague.demo.service.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class TaskService {

    private final TaskRepository taskRepo;
    private final SolutionRepository solutionRepo;
    private final TaskMapper taskMapper;

    @Autowired
    public TaskService(TaskRepository taskRepo, SolutionRepository solutionRepo, TaskMapper taskMapper) {
        this.taskRepo = taskRepo;
        this.solutionRepo = solutionRepo;
        this.taskMapper = taskMapper;
    }

    @Transactional(readOnly = true)
    public TasksDTO findAll() {
        TasksDTO tasks = new TasksDTO();
        List<TaskEntity> tasksList = taskRepo.findAll();
        tasks.setTasks(taskMapper.toDto(tasksList));
        return tasks;
    }

    @Transactional(readOnly = true)
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

    @Transactional(readOnly = true)
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

        //String taskTitle = taskRepo.findByTaskId(solution.getTask().getTaskId()).getTaskTitle();
        solution.setCreatedTime(LocalDateTime.now());
        TaskEntity task = taskRepo.findByTaskId(solution.getTask().getTaskId());
        TaskRunner taskRunner = new TaskRunner();
        ResultDTO result = new ResultDTO();
        String result1 = "";

        try {
            //  result = taskRunner.run(Searcher.getSource("MatrixSumm"), solution.getSolutionValue(), taskTitle); //MatrixSumm как заглушка
            result.setResult(taskRunner.run(task.getSourceTemplate(), solution.getSolutionValue(), task.getTaskTitle()));
        } catch (Exception e) {
            // result = "qwertyuio";
            e.printStackTrace();
        }

        solution.setTestResult(result.getResult());
        solutionRepo.save(solution);
        return result;
    }

    public void deleteTask(int taskId) {
        taskRepo.delete(findTaskById(taskId));
    }
}