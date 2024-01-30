package ru.komarov.springtask.task.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.komarov.springtask.task.exception.UserNotFoundException;
import ru.komarov.springtask.task.dto.UserRequest;
import ru.komarov.springtask.task.dto.UserResponse;
import ru.komarov.springtask.task.entity.User;
import ru.komarov.springtask.task.mapper.UserMapper;
import ru.komarov.springtask.task.repository.UserRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public User createUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public User createUser() {
        return new User();
    }

//    public UserRequest createUser() {
//        return new UserRequest();
//    }

    public User getUserById(Long userId) throws UserNotFoundException {
        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Пользователь не найден"));
        return user;
    }

    public Collection<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
    }

    public UserResponse updateUser(UserResponse user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        User updateUser = userRepository.save(existingUser);
        return UserMapper.mapToUserDto(updateUser);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }
}
