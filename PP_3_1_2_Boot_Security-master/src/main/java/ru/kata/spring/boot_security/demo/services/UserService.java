package ru.kata.spring.boot_security.demo.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    public List<User> getAllUsers();
    public void createNewUser(User user);
    public User getUser(int id);
    public void updateUser(User user);
    public void deleteUser(int id);
    public User findUserByUsername(String username);
}
