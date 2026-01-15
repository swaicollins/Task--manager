package com.example.taskmanager.service;

import com.example.taskmanager.dto.TaskDto;

import java.util.List;

public interface TaskService {
    TaskDto createTask(TaskDto taskDto);

    List<TaskDto> getAllTask();

    TaskDto getTaskById(Long id);

    TaskDto updateTask(Long id, TaskDto taskDto);

    void deleteTask(Long id);
}
