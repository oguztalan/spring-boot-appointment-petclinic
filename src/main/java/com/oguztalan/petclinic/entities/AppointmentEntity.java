package com.oguztalan.petclinic.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TBL_APPOINTMENTS")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class AppointmentEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "appointment_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;

	@Column(name = "appointment_time")
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	private Date time;

	@Column(name = "description")
	private String description;

	@Column(name = "priority")
	private String priority;

	@Column(name = "animal_name")
	private String animalName;

	@Column(name = "animal_type")
	private String animalType;

	@Column(name = "doctor")
	private String doctor;

	@Column(name = "note")
	private String note;

	@Column(name = "status")
	private Long status;

}
