package com.ravindu.todo.repository;

import com.ravindu.todo.entity.Task;
import com.ravindu.todo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
}