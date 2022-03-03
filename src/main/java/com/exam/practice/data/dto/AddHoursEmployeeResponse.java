package com.exam.practice.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO de Response para agregar horas trabajadas.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddHoursEmployeeResponse {

    /**
     * Atributo para Id.
     */
    private Integer id;

    /**
     * Atributo para Success.
     */
    private Boolean success;
}
