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
 * Entidad para generos.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "genders")
public class GendersEntity {

    /**
     * Atributo para Id de Genero.
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
}
