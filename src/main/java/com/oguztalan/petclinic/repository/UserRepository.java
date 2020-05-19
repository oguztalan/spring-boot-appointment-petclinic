package com.oguztalan.petclinic.repository;

import com.oguztalan.petclinic.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public abstract User findByUsername(String username);


}
