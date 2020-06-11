package com.oguztalan.petclinic.service.impl;

import com.oguztalan.petclinic.entities.AppointmentEntity;
import com.oguztalan.petclinic.exception.RecordNotFoundException;
import com.oguztalan.petclinic.model.Appointment;
import com.oguztalan.petclinic.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Qualifier("appointmentService")
public class AppointmentServiceImpl  {

	@Qualifier("appointmentRepository")
	@Autowired
	AppointmentRepository repository;

	public List<AppointmentEntity> listAllAppointment(){
		List<AppointmentEntity> result = repository.findAll();

		if (result.size() > 0 ) {
			result.sort(Comparator.comparing(AppointmentEntity::getDate));
			Collections.reverse(result);
			return result;
		}
		else
			return new ArrayList<AppointmentEntity>();

	}
	public List<AppointmentEntity> listActiveStatus(){
		List<AppointmentEntity> result = repository.findAllByActiveStatus();
		if (result.size() > 0) {
			return result;
		}
		return new ArrayList<>();
	}
	public List<AppointmentEntity> listCanceledStatus(){
		List<AppointmentEntity> result = repository.findAllByCanceledStatus();
		if (result.size() > 0) {
			return result;
		}
		return new ArrayList<>();
	}

	public List<AppointmentEntity> listFilterAppointment(Date startDate, Date endDate){

		List<AppointmentEntity> result = repository.findFilteredDates(startDate,endDate);
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
				newEntity.setDoctor(entity.getDoctor());
				newEntity.setStatus(entity.getStatus());
				newEntity.setOwnerName(entity.getOwnerName());
				newEntity.setNotes(entity.getNotes());
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
