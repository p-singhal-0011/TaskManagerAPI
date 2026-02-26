package com.priyansh.service;

import com.priyansh.entity.Task;
import com.priyansh.entity.User;
import com.priyansh.repository.TaskRepository;
import com.priyansh.repository.UserRepository;
import com.priyansh.exception.ApiException;
import com.priyansh.exception.ErrorCode;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    private User getCurrentUser() {

        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ApiException(ErrorCode.USER_NOT_FOUND));
    }

    public Page<Task> getTasks(Pageable pageable) {
        return taskRepository.findByUser(getCurrentUser(), pageable);
    }

    public Task createTask(Task task) {
        task.setUser(getCurrentUser());
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {

        User currentUser = getCurrentUser();

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ApiException(ErrorCode.TASK_NOT_FOUND));

        if (!task.getUser().getId().equals(currentUser.getId())) {
            throw new ApiException(ErrorCode.UNAUTHORIZED_ACTION);
        }

        taskRepository.delete(task);
    }
}