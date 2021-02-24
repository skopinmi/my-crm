package ru.geekbrains.services.dbservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.models.Status;
import ru.geekbrains.models.User;
import ru.geekbrains.repositories.StatusRepository;
import ru.geekbrains.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final StatusRepository statusRepository;


    public List<User> findByStatusId (Long id) {
        return statusRepository.findById(id).orElseThrow().getUsers();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(new User());
    }

    @Override
    public void remove (Long id) {
        userRepository.deleteById(id);
    }
}
