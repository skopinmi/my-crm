package ru.geekbrains.utilities;

import org.springframework.stereotype.Component;
import ru.geekbrains.models.Role;
import ru.geekbrains.models.Status;
import ru.geekbrains.models.User;
import ru.geekbrains.repositories.RoleRepository;
import ru.geekbrains.repositories.StatusRepository;
import ru.geekbrains.repositories.UserRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

//создает заполняет базу на настоящий момент с 1 клиентом


@Component
public class SampleData {

    RoleRepository roleRepository;
    StatusRepository statusRepository;
    UserRepository userRepository;

    public SampleData(RoleRepository roleRepository,
                      StatusRepository statusRepository,
                      UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.statusRepository = statusRepository;
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init() {
        Status status = new Status("VIP");
        Status status1 = new Status("Gold");
        Status status2 = new Status("default");


        User user = new User("misha", "12345678", "qwer@mail.com");
        User user1 = new User("masha", "87654321", "rewq@mail.com");
        User user2 = new User("oleg", "12348765", "qwre@mail.com");
        User user3 = new User("sasha", "43215678", "erwq@mail.com");

        user.setStatus(status);
        user1.setStatus(status1);
        user2.setStatus(status1);
        user3.setStatus(status2);


        Role role = new Role("ADMIN");
        List<User> admin = new ArrayList<>();
        admin.add(user);
        role.setUsers(admin);
        Role role1 = new Role("MANAGER");
        List<User> manager = new ArrayList<>();
        manager.add(user1);
        role1.setUsers(manager);
        Role role2 = new Role("USER");
        List<User> users = new ArrayList<>();
        users.add(user2);
        users.add(user3);
        role2.setUsers(users);


        statusRepository.save(status);
        statusRepository.save(status1);
        statusRepository.save(status2);

        userRepository.save(user);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        roleRepository.save(role);
        roleRepository.save(role1);
        roleRepository.save(role2);


    }
}