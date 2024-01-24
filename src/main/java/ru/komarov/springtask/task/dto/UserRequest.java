package ru.komarov.springtask.task.dto;

import lombok.Getter;
import lombok.Setter;
import ru.komarov.springtask.task.entity.User;

@Setter
@Getter
public class UserRequest {
    private String name;
    private String email;
    private String password;

    public User mapToUser() {
        return new User(name, email, password);
    }
}
