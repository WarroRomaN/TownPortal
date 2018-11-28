package com.zmk.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
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

}
