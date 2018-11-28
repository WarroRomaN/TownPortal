package com.zmk.repository;

import com.zmk.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority getAuthorityByAuthority(String authority);

}
