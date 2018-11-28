package com.zmk;

import com.zmk.entity.Authority;
import com.zmk.entity.User;
import com.zmk.exception.AuthorityAlreadyExistsException;
import com.zmk.exception.EmailAlreadyExistsException;
import com.zmk.exception.MobilePhoneAlreadyExistsException;
import com.zmk.exception.UsernameAlreadyExistsException;
import com.zmk.service.AuthorityService;
import com.zmk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;

@SpringBootApplication
public class Application implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {

        Authority adminAuthority = new Authority();
        adminAuthority.setId(9L);
        adminAuthority.setAuthority("Admin");
        try {
            authorityService.createAuthority(adminAuthority);
        } catch (AuthorityAlreadyExistsException e) {
            e.printStackTrace();
        }

        Authority userAuthority = new Authority();
        userAuthority.setId(8L);
        userAuthority.setAuthority("User");
        try {
            authorityService.createAuthority(userAuthority);
        } catch (AuthorityAlreadyExistsException e) {
            e.printStackTrace();
        }

        authorityService.loadAllAuthorities().forEach(System.out::println);

        User admin = new User();
        admin.setAccountNonExpired(true);
        admin.setAccountNonLocked(true);
        admin.setAuthorities(new HashSet<>(authorityService.loadAllAuthorities()));
        admin.setBirthday(Date.valueOf("05/11/1995"));
        admin.setEmail("1Admin@email.com");
        admin.setDateRegistration(Date.valueOf(LocalDate.now()));
        admin.setMobilePhone("+380659832565");
        admin.setEnabled(true);
        admin.setFirstName("Artur");
        admin.setLastName("Nemiroff");
        admin.setCredentialsNonExpired(true);
        admin.setPassword("1Admin");
        try {
            userService.createUser(admin);
        } catch (UsernameAlreadyExistsException | EmailAlreadyExistsException | MobilePhoneAlreadyExistsException e) {
            e.printStackTrace();
        }
        userService.loadAllUsers().forEach(System.out::println);

    }
}
