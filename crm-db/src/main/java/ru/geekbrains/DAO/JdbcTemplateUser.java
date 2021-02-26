package ru.geekbrains.DAO;

import ru.geekbrains.models.User;

import java.util.List;

public interface JdbcTemplateUser {

    User findById(Long id);
    List<User> findAll();
    void deleteById (Long id);
    void save(User user);
}
