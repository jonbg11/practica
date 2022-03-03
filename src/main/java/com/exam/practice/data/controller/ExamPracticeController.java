package com.exam.practice.data.controller;

import com.exam.practice.data.dto.*;
import com.exam.practice.data.service.EmployeesHoursService;
import com.exam.practice.data.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Capa controller que expone los endpoints de las distintas operaciones.
 */
@RestController
@RequestMapping("/practice")
public class ExamPracticeController {

    /**
     * Componente service de empleado.
     */
    @Autowired
    private EmployeesService employeesService;

    /**
     * Componente service de horas trabajadas.
     */
    @Autowired
    private EmployeesHoursService employeesHoursService;

    /** The constant error. */
    private static final int CODERROR = 500;

    /**
     * The constant ok.
     */
    private static final int CODEOK = 200;

    /**
     * The constant not found info.
     */
    public static final int CODENOTINFO = 404;

    /**
     * Operacion que inserta un nuevo empleado.
     *
     * @param request the request
     * @return the response entity
     */
    @PostMapping("/insertEmployee")
    public ResponseEntity<AddEmployeeResponse> insertEmployee(final @RequestBody EmployeesRequest request) {
        AddEmployeeResponse response = employeesService.insertEmployees(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Operacion que inserta horas trabajadas de un empleado.
     *
     * @param request the request
     * @return the response entity
     */
    @PostMapping("/insertHoursEmployee")
    public ResponseEntity<AddHoursEmployeeResponse> insertHoursEmployee(final @RequestBody EmployeesHoursRequest request) {
        AddHoursEmployeeResponse response = employeesHoursService.insertHoursEmployees(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Operacion que obtiene horas trabajadas de un empleado.
     *
     * @param request the request
     * @return the response entity
     */
    @GetMapping("/getHoursEmployee")
    public ResponseEntity<GetHoursEmployeeResponse> getHoursEmployee(final @RequestBody GetEmployeesHoursRequest request) {
        GetHoursEmployeeResponse response = employeesHoursService.getWorkedHours(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Operacion que obtiene salario de un empleado.
     *
     * @param request the request
     * @return the response entity
     */
    @GetMapping("/getSalaryEmployee")
    public ResponseEntity<GetSalaryEmployeeResponse> getSalaryEmployee(final @RequestBody GetEmployeesSalaryRequest request) {
        GetSalaryEmployeeResponse response = employeesService.getSalary(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
