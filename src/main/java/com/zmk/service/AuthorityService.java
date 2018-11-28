package com.zmk.service;

import com.zmk.entity.Authority;
import com.zmk.exception.AuthorityAlreadyExistsException;
import com.zmk.exception.AuthorityNotFoundException;
import com.zmk.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    public Authority loadAuthorityByAuthority(String authorityName) throws AuthorityNotFoundException {
        Authority authority = authorityRepository.getAuthorityByAuthority(authorityName);
        if (isAuthorityNotFound(authority)) {
            throw new AuthorityNotFoundException("Authority with the authority \"" + authorityName + "\" not found.");
        }
        return authority;
    }

    public List<Authority> loadAllAuthorities() {
        return authorityRepository.findAll();
    }

    public void createAuthority(Authority authority) throws AuthorityAlreadyExistsException {
        if (!isAuthorityNotFound(authorityRepository.getAuthorityByAuthority(authority.getAuthority()))) {
            throw new AuthorityAlreadyExistsException("Authority with the username \"" + authority.getAuthority() + "\" already exists.");
        }
        authorityRepository.save(authority);
    }

    private boolean isAuthorityNotFound(Authority authority) {
        return authority == null;
    }


}
