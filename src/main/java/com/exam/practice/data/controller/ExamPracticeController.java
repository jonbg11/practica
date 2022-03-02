package com.exam.practice.data.controller;

import com.exam.practice.data.dto.AddEmployeeResponse;
import com.exam.practice.data.dto.EmployeesRequest;
import com.exam.practice.data.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Capa controller que expone los endpoints de las distintas operaciones.
 */
@RestController
@RequestMapping("/practice")
public class ExamPracticeController {

    /**
     * Componente service de Persona.
     */
    @Autowired
    private EmployeesService employeesService;

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
     * Operacion que devuelve todos los registros.
     *
     * @param request the request
     * @return the response entity
     */
    @PostMapping("/insertEmployee")
    public ResponseEntity<AddEmployeeResponse> insertEmployee(final @RequestBody EmployeesRequest request) {
        AddEmployeeResponse response = employeesService.insertEmployees(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
