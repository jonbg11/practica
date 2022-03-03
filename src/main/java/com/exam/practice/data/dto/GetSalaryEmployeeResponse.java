package com.exam.practice.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO de Response para salario de empleados.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetSalaryEmployeeResponse {

    /**
     * Atributo para total pago.
     */
    private Double payment;

    /**
     * Atributo para Success.
     */
    private Boolean success;
}
