package ru.komarov.springtask.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.komarov.springtask.task.entity.User;

import java.util.Collection;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Collection<User> findByNameContaining(String name);

}
