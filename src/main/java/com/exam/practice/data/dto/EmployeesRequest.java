package com.exam.practice.data.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * DTO de Request para empleados.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeesRequest {

    /**
     * Atributo para Id de Genero.
     */
    private Integer gender_id;

    /**
     * Atributo para Id de Trabajo.
     */
    private Integer job_id;

    /**
     * Atributo para Nombre.
     */
    private String name;

    /**
     * Atributo para Apellido.
     */
    private String last_name;

    /**
     * Atributo para Fecha de nacimiento.
     */
    private Date birthdate;
}
