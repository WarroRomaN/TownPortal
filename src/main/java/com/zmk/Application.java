package com.zmk;

import com.zmk.entity.Authority;
import com.zmk.entity.User;
import com.zmk.exception.EmailAlreadyExistsException;
import com.zmk.exception.MobilePhoneAlreadyExistsException;
import com.zmk.exception.UsernameAlreadyExistsException;
import com.zmk.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
@Log4j2
public class Application implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) {

        User admin = new User();
        admin.setUsername("1Admin");
        admin.setAccountNonExpired(true);
        admin.setAccountNonLocked(true);
        admin.setAuthorities(new HashSet<>(Arrays.asList(Authority.values())));
        admin.setBirthday(Date.valueOf(LocalDate.now()));
        admin.setEmail("1Admin@email.com");
        admin.setMobilePhone("+380659832565");
        admin.setEnabled(true);
        admin.setFirstName("Artur");
        admin.setLastName("Nemiroff");
        admin.setCredentialsNonExpired(true);
        admin.setPassword("1Admin");
        try {
            userService.createUser(admin);
        } catch (UsernameAlreadyExistsException | EmailAlreadyExistsException | MobilePhoneAlreadyExistsException e) {
            log.warn(e.getMessage());
        }
        userService.loadAllUsers().forEach(System.out::println);

    }
}
