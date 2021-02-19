package ru.geekbrains.services;

import ru.geekbrains.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.repositories.StatusRepository;
import ru.geekbrains.repositories.UserRepository;
import ru.geekbrains.services.repr.UserRepr;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private StatusRepository statusRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           StatusRepository statusRepository) {
        this.userRepository = userRepository;
        this.statusRepository = statusRepository;
    }

    public List<UserRepr> findByStatusId (Long id) {
        return statusRepository.findById(id).get().getUsers()
                                                .stream().map(UserRepr :: new)
                                                .collect(Collectors.toList());
    }

    public List<UserRepr> findAll() {
        return userRepository.findAll().stream()
                .map(UserRepr::new)
                .collect(Collectors.toList());
    }

    @Override
    public void save(UserRepr userRepr) {

    }

    @Override
    public UserRepr findById(Long id) {
        return new UserRepr(userRepository.findById(id).get());
    }

    @Override
    public void delete(Long id) {

    }
}
