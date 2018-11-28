package com.zmk.service;

import com.zmk.entity.User;
import com.zmk.exception.*;
import com.zmk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);
        if (isUserNotFound(user)) {
            throw new UsernameNotFoundException("User with the username \"" + username + "\" not found.");
        }
        return user;
    }

    public User loadUserByEmail(String email) throws EmailNotFoundException {
        User user = userRepository.getUserByEmail(email);
        if (isUserNotFound(user)) {
            throw new EmailNotFoundException("User with the email \"" + email + "\" not found.");
        }
        return user;
    }

    public User loadUserByMobilePhone(String mobilePhone) throws MobilePhoneNotFoundException {
        User user = userRepository.getUserByMobilePhone(mobilePhone);
        if (isUserNotFound(user)) {
            throw new EmailNotFoundException("User with the mobile phone \"" + mobilePhone + "\" not found.");
        }
        return user;
    }

    public List<User> loadAllUsers() {
        return userRepository.findAll();
    }

    public void createUser(User user) throws UsernameAlreadyExistsException, EmailAlreadyExistsException, MobilePhoneAlreadyExistsException {
        if (!isUserNotFound(userRepository.getUserByUsername(user.getUsername()))) {
            throw new UsernameAlreadyExistsException("User with the username \"" + user.getUsername() + "\" already exists.");
        }
        if (!isUserNotFound(userRepository.getUserByEmail(user.getEmail()))) {
            throw new EmailAlreadyExistsException("User with the email \"" + user.getEmail() + "\" already exists.");
        }
        if (!isUserNotFound(userRepository.getUserByUsername(user.getUsername()))) {
            throw new MobilePhoneAlreadyExistsException("User with the mobile phone \"" + user.getMobilePhone() + "\" already exists.");
        }
        userRepository.save(user);
    }

    private boolean isUserNotFound(User user) {
        return user == null;
    }
}