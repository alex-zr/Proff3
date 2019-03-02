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
        Optional<User> userOptional = getUser(login);
        User user = userOptional.orElseThrow(() -> new UserException("user with login " + login + " not found"));
        return user.getPass().equals(password);
    }

    private Optional<User> getUser(String login) {
        User probe = new User();
        probe.setLogin(login);
        Example<User> userExample = Example.of(probe);
        return repository.findOne(userExample);
    }

    public long registration(String login, String password) throws UserException {
        if (login == null) {
            throw new UserException("login is null");
        }
        Optional<User> userOptional = getUser(login);
        if (userOptional.isPresent()) {
            throw new UserException("User with login" + login + " is already registered");
        }
        User user = new User(login, password);
        repository.save(user);
        return user.getId();
    }
}
