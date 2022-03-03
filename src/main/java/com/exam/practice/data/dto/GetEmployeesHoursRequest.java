package com.exam.practice.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * DTO de Request para horas trabajadas para empleados.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetEmployeesHoursRequest {

    /**
     * Atributo para Id de Empleado.
     */
    private Integer employee_id;

    /**
     * Atributo para fecha de inicio.
     */
    private Date start_date;

    /**
     * Atributo para fecha de fin.
     */
    private Date end_date;
}
