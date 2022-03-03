package com.exam.practice.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO de Response para obtener agregar horas trabajadas.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetHoursEmployeeResponse {

    /**
     * Atributo para total de horas trabajadas.
     */
    private Integer total_worked_hours;

    /**
     * Atributo para Success.
     */
    private Boolean success;
}
