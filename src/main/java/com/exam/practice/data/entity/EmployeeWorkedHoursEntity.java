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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_worked_hours")
public class EmployeeWorkedHoursEntity {

    /**
     * Atributo para Id de horas trabajadas.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    /**
     * Atributo para Id de Empleado.
     */
    @Column(name = "EMPLOYEE_ID")
    private Integer employeeId;

    /**
     * Atributo para horas trabajadas.
     */
    @Column(name = "WORKED_HOURS")
    private Integer workedHours;

    /**
     * Atributo para Fecha de horas.
     */
    @Column(name = "WORKED_DATE")
    private Date workedDate;
}
