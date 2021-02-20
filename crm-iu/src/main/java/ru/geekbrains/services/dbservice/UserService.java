package ru.geekbrains.services;

import ru.geekbrains.services.repr.UserRepr;
import java.util.List;

public interface UserService {

    void save(UserRepr userRepr);

    List<UserRepr> findAll();

    UserRepr findById(Long id);

    void remove(Long id);
}
