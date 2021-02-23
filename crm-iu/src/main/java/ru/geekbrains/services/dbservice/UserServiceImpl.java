package ru.geekbrains.services.dbservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.models.User;
import ru.geekbrains.repositories.StatusRepository;
import ru.geekbrains.repositories.UserRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final StatusRepository statusRepository;

    public List<User> findByStatusId (Long id) {
        return statusRepository.findById(id).get().getUsers();
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

//    @Override
//    public void save(User user) {

        // TODO доделать
//    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void remove (Long id) {
        userRepository.deleteById(id);
    }
}
