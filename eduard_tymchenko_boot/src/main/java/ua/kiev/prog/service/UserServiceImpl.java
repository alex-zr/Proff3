package ua.kiev.prog.service;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import ua.kiev.prog.dao.UserRepository;
import ua.kiev.prog.domain.User;
import ua.kiev.prog.exception.UserException;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    public boolean login(String login, String password) throws UserException {
        User probe = new User();
        probe.setLogin(login);
        Example<User> userExample = Example.of(probe);
        Optional<User> userOptional = repository.findOne(userExample);
        User user = userOptional.orElseThrow(() -> new UserException("user with login " + login + " not found"));
        return user.getPass().equals(password);
    }

    public long registration(String login, String password) throws UserException {
        return 0; // todo
    }
}
