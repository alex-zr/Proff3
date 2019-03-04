package ua.kiev.prog.service;

import ua.kiev.prog.exception.UserException;

public interface UserService {

    boolean login(String login, String password) throws UserException;
    long registration(String login, String password) throws UserException;
}
