package com.oguztalan.petclinic.repository;

import com.oguztalan.petclinic.entities.AppointmentEntity;
import com.oguztalan.petclinic.model.Appointment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppointmentRepository extends CrudRepository<AppointmentEntity, Long> {

	List<AppointmentEntity> findAll();

}
