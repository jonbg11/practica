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

/**
 * Entidad para trabajos.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jobs")
public class JobsEntity {

    /**
     * Atributo para Id de Trabajo.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    /**
     * Atributo para Nombre.
     */
    @Column(name = "NAME")
    private String name;

    /**
     * Atributo para Salario.
     */
    @Column(name = "SALARY")
    private Double salary;
}
