package com.oguztalan.petclinic.repository;

import com.oguztalan.petclinic.entities.AppointmentEntity;
import com.oguztalan.petclinic.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {

	List<AppointmentEntity> findAll();

	@Query(value = "from AppointmentEntity t where date BETWEEN :startDate AND :endDate")
	List<AppointmentEntity> findFilteredDates(@Param("startDate") Date startDate, @Param("endDate")Date endDate);

	@Query(value = "from AppointmentEntity t where status = 1")
	List<AppointmentEntity> findAllByActiveStatus();



}
