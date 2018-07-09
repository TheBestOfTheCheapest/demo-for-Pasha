package com.example.demo.service;

import com.example.demo.domain.TaskEntity;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.core.Searcher;
import com.example.demo.service.core.TaskRunner;
import com.example.demo.service.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepo;

    public List<TaskEntity> findAll(){
        return taskRepo.findAll();
    }

    public TaskEntity findTaskById(int id){
        return taskRepo.findById(id);
    }

    public TaskEntity add(String taskTitle, String taskText, String sourceSample){
        TaskEntity task = new TaskEntity();
        task.setTaskTitle(taskTitle);
        task.setTaskText(taskText);
        task.setSourceSample(sourceSample);
        taskRepo.save(task);
        return task;
    }

    public String getResult(int taskId, String solutionId, String solution){
        String taskTitle = taskRepo.findById(taskId).getTaskTitle();
        TaskRunner taskRunner = new TaskRunner();
        String result= "";
        try {
            result = taskRunner.run(Searcher.getSource("MatrixSumm"), solution, taskTitle); //MatrixSumm как заглушка
        } catch (Exception e) {
            e.printStackTrace();
        }
        //todo найти и прочитать файл по задаче
        //todo найти класс шаблона задачи
        //todo передать в TaskRunner код и шаблон
        //todo вернуть результат
        return result;
    }

    public void deleteTask(int id) {
        taskRepo.delete(findTaskById(id));
    }
}
