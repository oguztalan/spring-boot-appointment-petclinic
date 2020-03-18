package com.oguztalan.petclinic.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "appointments")
public class AppointmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;

	@Column(name = "time")
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	private Date time;

	@Column(name = "description")
	private String description;

	@Column(name = "priority")
	private String priority;

	@Column(name="username", insertable=false, updatable=false)
	private String username;

	public AppointmentEntity() {
		super();
	}

	public AppointmentEntity(Long id, Date date, Date time, String description, String priority, boolean active) {
		super();
		this.id = id;
		this.date = date;
		this.time = time;
		this.description = description;
		this.priority = priority;
	}

	public AppointmentEntity(Date date, Date time, String description, String priority, boolean active) {
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

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", date=" + date + ", time=" + time + ", description=" + description
				+ ", priority=" + priority +   ", username=" + username + "]";
	}
}
