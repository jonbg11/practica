package com.exam.practice.data.service;

import com.exam.practice.data.dto.AddEmployeeResponse;
import com.exam.practice.data.dto.EmployeesRequest;
import com.exam.practice.data.entity.EmployeesEntity;
import com.exam.practice.data.repository.EmployeesRepository;
import com.exam.practice.data.repository.GendersRepository;
import com.exam.practice.data.repository.JobsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

/**
 * ervicio que contiene la logica de negocio para Empleados.
 */
@Service
public class EmployeesService {

    /**
     * Componente repository de Empleados.
     */
    @Autowired
    private EmployeesRepository employeesRepository;

    /**
     * Componente repository de Trabajos.
     */
    @Autowired
    private JobsRepository jobsRepository;

    /**
     * Componente repository de Genero.
     */
    @Autowired
    private GendersRepository gendersRepository;

    /** The constant 18. */
    private static final int MAYOR_YEARS = 18;

    /**
     * Metodo para guardar empleado.
     *
     * @param request the request
     * @return the data
     */
    public AddEmployeeResponse insertEmployees(final EmployeesRequest request) {

        AddEmployeeResponse response = new AddEmployeeResponse();

        List<EmployeesEntity> listPerson = employeesRepository.
                findAllByNameAndLastName(request.getName(), request.getLast_name());

        if (!listPerson.isEmpty()) {
            response.setId(null);
            response.setSuccess(false);
            return response;
        }

        LocalDate fechaNac = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd")
                .format(request.getBirthdate()));

        LocalDate dateNow = LocalDate.now();
        Period periodo = Period.between(fechaNac, dateNow);
        int yearsOld = periodo.getYears();

        if (yearsOld < MAYOR_YEARS) {
            response.setId(null);
            response.setSuccess(false);
            return response;
        }

        boolean existJob = jobsRepository.existsById(request.getJob_id());

        boolean existGender = gendersRepository.existsById(request.getGender_id());

        if (!existGender || !existJob) {
            response.setId(null);
            response.setSuccess(false);
            return response;
        }

        try {
            ModelMapper modelMapper = new ModelMapper();
            EmployeesEntity item = modelMapper.map(request, EmployeesEntity.class);
            item.setLastName(request.getLast_name());
            EmployeesEntity itemSave = employeesRepository.saveAndFlush(item);
            response.setId(itemSave.getId());
            response.setSuccess(true);
        } catch (Exception ex) {
            response.setId(null);
            response.setSuccess(false);
        }
        return response;
    }
}
