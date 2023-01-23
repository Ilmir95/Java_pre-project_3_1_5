package ru.kata.spring.boot_security.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.configs.PasswordEncoderConfiguration;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;

import java.util.HashSet;
import java.util.Set;
@Component
public class DefUser implements CommandLineRunner {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoderConfiguration passwordEncoder;

    @Autowired
    public DefUser(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoderConfiguration passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        Role roleMentror = new Role("ADMIN");
        Role roleUser = new Role("USER");
        roleRepository.save(roleMentror);
        roleRepository.save(roleUser);
        Set<Role> userRole = new HashSet<>();
        userRole.add(roleUser);
        Set<Role> mentorRole = new HashSet<>();
        mentorRole.add(roleMentror);
        mentorRole.add(roleUser);
        User ilmir = new User("Ilmir", "Khafizov", 27, "ilmir131313@yandex.ru", "user", passwordEncoder.passwordEncoder().encode("123456"), userRole); // password 123456
        User admin = new User("Admin", "Kata", 30, "mentor@mail.ru", "admin", passwordEncoder.passwordEncoder().encode("123456"), mentorRole);
        User mentor = new User("Mentor", "Kata", 30, "mentor@mail.ru", "mentor", passwordEncoder.passwordEncoder().encode("123456"), mentorRole); // password 123456
        userRepository.save(ilmir);
        userRepository.save(admin);
        userRepository.save(mentor);
    }
}
