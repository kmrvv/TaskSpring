package ru.komarov.springtask.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.komarov.springtask.task.model.User;

import java.util.List;

public interface Repository extends JpaRepository<User, Long> {
    List<User> findByNameContaining(String name);
}
