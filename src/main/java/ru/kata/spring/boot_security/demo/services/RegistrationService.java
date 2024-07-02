package ru.kata.spring.boot_security.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.User;

@Service
public class RegistrationService {

    private final UserDao userDao;

    @Autowired
    public RegistrationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void register(User user) {
        userDao.saveUser(user);
    }
}
