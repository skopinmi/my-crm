package ru.geekbrains.services;

import ru.geekbrains.models.User;
import ru.geekbrains.services.repr.UserRepr;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void save(UserRepr userRepr);

    List<UserRepr> findAll();

    UserRepr findById(Long id);

    void delete(Long id);
}
