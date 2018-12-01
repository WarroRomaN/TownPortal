package com.zmk.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

@Getter
@ToString
@AllArgsConstructor
public enum Authority implements GrantedAuthority {
    ADMIN(1L, "Admin"),
    USER(2L, "User");

    private Long id;
    private String authority;

}