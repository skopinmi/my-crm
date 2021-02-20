package ru.geekbrains.services.dbservice;

import ru.geekbrains.services.dbservice.repr.UserRepr;
import java.util.List;

public interface UserService {

    void save(UserRepr userRepr);

    List<UserRepr> findAll();

    UserRepr findById(Long id);

    void remove(Long id);
}
