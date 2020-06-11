package com.oguztalan.petclinic.repository;

import com.oguztalan.petclinic.entities.AppointmentEntity;
import com.oguztalan.petclinic.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    public abstract User findByUsername(String username);



}
