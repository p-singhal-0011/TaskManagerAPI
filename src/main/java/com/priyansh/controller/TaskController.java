package com.priyansh.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priyansh.entity.Task;
import com.priyansh.service.TaskService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public Page<Task> getAllTasks(Pageable pageable) {
        return taskService.getTasks(pageable);
    }


    @PostMapping
    public Task createTask(@RequestBody Task task,
                           Authentication authentication) {

        String email = authentication.getName();
        return taskService.createTask(task);
    }

    
    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteTask(@PathVariable Long id,
                                             Authentication authentication) {

        String email = authentication.getName();
        taskService.deleteTask(id);

        return ResponseEntity.ok("Deleted successfully");
    }

}
