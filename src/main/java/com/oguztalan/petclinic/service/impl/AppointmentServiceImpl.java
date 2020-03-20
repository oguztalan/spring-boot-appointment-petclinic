package com.oguztalan.petclinic.service.impl;

import com.oguztalan.petclinic.entities.AppointmentEntity;
import com.oguztalan.petclinic.exception.RecordNotFoundException;
import com.oguztalan.petclinic.model.Appointment;
import com.oguztalan.petclinic.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl  {

	@Qualifier("appointmentRepository")
	@Autowired
	AppointmentRepository repository;

	public List<AppointmentEntity> listAllAppointment(){
		List<AppointmentEntity> result = repository.findAll();

		if (result.size() > 0 )
			return  result;
		else
			return new ArrayList<AppointmentEntity>();

	}

	public AppointmentEntity getAppointmentById(Long id) throws RecordNotFoundException{
		Optional<AppointmentEntity> appointment = repository.findById(id);
		if (appointment.isPresent())
			return appointment.get();
		else
			throw new RecordNotFoundException("Verilen id ile kayıt bulunamadı!");
	}

	public AppointmentEntity createOrUpdate(AppointmentEntity entity){

		if (entity.getId() == null){
			entity = repository.save(entity);
			return entity;
		}
		else {
			Optional<AppointmentEntity> appointment = repository.findById(entity.getId());

			if (appointment.isPresent()){
				AppointmentEntity newEntity = appointment.get();
				newEntity.setDate(entity.getDate());
				newEntity.setDescription(entity.getDescription());
				newEntity.setPriority(entity.getPriority());
				newEntity.setTime(entity.getTime());
				newEntity.setAnimalName(entity.getAnimalName());
				newEntity.setAnimalType(entity.getAnimalType());
				newEntity = repository.save(newEntity);

				return newEntity;
			}
			else {
				entity = repository.save(entity);

				return entity;
			}

		}
	}

	public void deleteAppointmentById(Long id) throws RecordNotFoundException{
		Optional<AppointmentEntity> appointment = repository.findById(id);

		if (appointment.isPresent()){
			repository.deleteById(id);
		}else {
			throw new RecordNotFoundException("Böyle bir kayıt bulunamadı");
		}
	}


}
