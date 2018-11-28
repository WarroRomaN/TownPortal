package com.zmk.entity;

import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
//@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USR")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "USERNAME", nullable = false, unique = true)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "BIRTHDAY", nullable = false)
    private Date birthday;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Authority> authorities = new HashSet<>();

    @Column(name = "DATE_REGISTRATION", nullable = false)
    private Date dateRegistration;

    @Column(name = "MOBILE_PHONE", nullable = false, unique = true)
    private String mobilePhone;

    @Column(name = "ACCOUNT_NON_EXPIRED", nullable = false)
    private boolean accountNonExpired;

    @Column(name = "ACCOUNT_NON_LOCKED", nullable = false)
    private boolean accountNonLocked;

    @Column(name = "CREDENTIALS_NON_EXPIRED", nullable = false)
    private boolean credentialsNonExpired;

    @Column(name = "ENABLED", nullable = false)
    private boolean enabled;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", dateRegistration=" + dateRegistration +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", accountNonExpired=" + accountNonExpired +
                ", accountNonLocked=" + accountNonLocked +
                ", credentialsNonExpired=" + credentialsNonExpired +
                ", enabled=" + enabled +
                '}';
    }
}
