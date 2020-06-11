package com.oguztalan.petclinic.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="active")
    private boolean active;


    @OneToMany(fetch = FetchType.EAGER)
    private Set<UserRole> userRole = new HashSet<UserRole>();

    @OneToMany(fetch=FetchType.EAGER)
    private List<AppointmentEntity> appointments;


}
