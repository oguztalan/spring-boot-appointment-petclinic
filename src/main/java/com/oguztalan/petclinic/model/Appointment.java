package com.oguztalan.petclinic.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Appointment {

	private Long id;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	@DateTimeFormat(pattern="HH:mm")
	private Date time;
	private String description;
	private String priority;
	private String animalName;
	private String animalType;
	private String doctor;

	public Appointment() {
		super();
	}

	public Appointment(Long id, Date date, Date time, String description, String priority, boolean active, User user) {
		super();
		this.id = id;
		this.date = date;
		this.time = time;
		this.description = description;
		this.priority = priority;
	}
	
	public Appointment(Long id, Date date, Date time, String description, String priority, boolean active) {
		super();
		this.id = id;
		this.date = date;
		this.time = time;
		this.description = description;
		this.priority = priority;
	}

	public Appointment(Date date, Date time, String description, String priority, boolean active) {
		super();
		this.date = date;
		this.time = time;
		this.description = description;
		this.priority = priority;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getAnimalName() {
		return animalName;
	}

	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	public String getAnimalType() {
		return animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", date=" + date + ", time=" + time + ", description=" + description
				+ ", priority=" + priority ;
	}
}
