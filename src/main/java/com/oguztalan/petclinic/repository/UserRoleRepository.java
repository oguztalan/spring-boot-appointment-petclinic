package com.oguztalan.petclinic.repository;

import com.oguztalan.petclinic.entities.User;
import com.oguztalan.petclinic.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Repository("userRoleRepository")
public interface UserRoleRepository extends JpaRepository<UserRole, Serializable> {


    @Transactional
    @Modifying
    @Query(value = "delete from UserRole where username = :usernameId")
    void deleteByUsernameId(@Param("usernameId") Integer id);

}
