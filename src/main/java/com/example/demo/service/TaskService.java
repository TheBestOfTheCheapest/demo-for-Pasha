package com.example.demo.service;

import com.example.demo.domain.SolutionEntity;
import com.example.demo.domain.TaskEntity;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.core.Searcher;
import com.example.demo.service.core.TaskRunner;
import com.example.demo.service.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepo;

    public List<TaskEntity> findAll(){
        return taskRepo.findAll();
    }

    public TaskEntity findTaskById(int taskId){
        return taskRepo.findByTaskId(taskId);
    }

    public TaskEntity add(TaskDTO taskDTO){
        TaskEntity task = new TaskEntity();
        task.setTaskTitle(taskDTO.getTaskTitle());
        task.setTaskText(taskDTO.getTaskText());
        task.setSourceSample(taskDTO.getSourceSample());
        taskRepo.save(task);
        return task;
    }

    public String getResult(SolutionEntity solution){


        String taskTitle = taskRepo.findByTaskId(solution.getTask().getTaskId()).getTaskTitle();
        TaskRunner taskRunner = new TaskRunner();
        String result= "";
        try {
            result = taskRunner.run(Searcher.getSource("MatrixSumm"), solution.getSolutionValue(), taskTitle); //MatrixSumm как заглушка
        } catch (Exception e) {
            result = "qwertyuio";
            e.printStackTrace();
        }
        //todo найти и прочитать файл по задаче
        //todo найти класс шаблона задачи
        //todo передать в TaskRunner код и шаблон
        //todo вернуть результат
        return result;
    }

    public void deleteTask(int taskId) {
        taskRepo.delete(findTaskById(taskId));
    }
}
