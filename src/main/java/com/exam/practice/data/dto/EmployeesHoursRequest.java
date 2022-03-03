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
public class EmployeesHoursRequest {

    /**
     * Atributo para Id de Empleado.
     */
    private Integer employee_id;

    /**
     * Atributo para horas trabajadas.
     */
    private Integer worked_hours;

    /**
     * Atributo para fecha de registro.
     */
    private Date worked_date;
}
