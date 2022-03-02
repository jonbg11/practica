package com.exam.practice.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

/**
 * Entidad para empleados.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class EmployeesEntity {

    /**
     * Atributo para Id de Empleado.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    /**
     * Atributo para Id de Genero.
     */
    @Column(name = "GENDER_ID")
    private Integer genderId;

    /**
     * Atributo para Id de Trabajo.
     */
    @Column(name = "JOB_ID")
    private Integer jobId;

    /**
     * Atributo para Nombre.
     */
    @Column(name = "NAME")
    private String name;

    /**
     * Atributo para Apellido.
     */
    @Column(name = "LAST_NAME")
    private String lastName;

    /**
     * Atributo para Fecha de nacimiento.
     */
    @Column(name = "BIRTHDATE")
    private Date birthdate;
}
