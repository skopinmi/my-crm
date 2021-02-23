package ru.geekbrains.services.dbservice;

import ru.geekbrains.models.User;
import java.util.List;

public interface UserService {

//    void save(User user);

    List<User> findAll();

    User findById(Long id);

    void remove(Long id);
}
