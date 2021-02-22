package ru.geekbrains.services.dbservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.repositories.StatusRepository;
import ru.geekbrains.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;
import ru.geekbrains.services.dbservice.repr.UserRepr;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final StatusRepository statusRepository;

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

        // TODO доделать
    }

    @Override
    public UserRepr findById(Long id) {
        return new UserRepr(userRepository.findById(id).get());
    }

    @Override
    public void remove (Long id) {
        userRepository.deleteById(id);
    }
}
