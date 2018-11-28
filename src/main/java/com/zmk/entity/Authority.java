package com.zmk.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
//@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "AUTHORITY")
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue
    @Column(name = "AUTHORITY_ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "AUTHORITY", nullable = false, unique = true)
    private String authority;

    @ManyToMany(mappedBy = "authorities")
    private Set<User> users = new HashSet<>();

    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", authority='" + authority + '\'' +
                '}';
    }
}
