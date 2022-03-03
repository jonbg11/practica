package com.exam.practice.data.service;

import com.exam.practice.data.dto.AddEmployeeResponse;
import com.exam.practice.data.dto.EmployeesRequest;
import com.exam.practice.data.dto.GetEmployeesSalaryRequest;
import com.exam.practice.data.dto.GetSalaryEmployeeResponse;
import com.exam.practice.data.entity.EmployeeWorkedHoursEntity;
import com.exam.practice.data.entity.EmployeesEntity;
import com.exam.practice.data.entity.JobsEntity;
import com.exam.practice.data.repository.EmployeeWorkedHoursRepository;
import com.exam.practice.data.repository.EmployeesRepository;
import com.exam.practice.data.repository.GendersRepository;
import com.exam.practice.data.repository.JobsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

/**
 * Servicio que contiene la logica de negocio para Empleados.
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

    /**
     * Componente repository de Empleados.
     */
    @Autowired
    private EmployeeWorkedHoursRepository employeeWorkedHoursRepository;

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

    /**
     * Obtiene salario de empleado.
     *
     * @param request the request
     * @return the salary
     */
    public GetSalaryEmployeeResponse getSalary(final GetEmployeesSalaryRequest request) {

        GetSalaryEmployeeResponse response = new GetSalaryEmployeeResponse();

        List<EmployeesEntity> employee = employeesRepository.findAllById(request.getEmployee_id());

        if (employee.isEmpty()) {
            response.setPayment(null);
            response.setSuccess(false);
            return response;
        }

        request.getStart_date().setHours(0);
        request.getStart_date().setMinutes(0);
        request.getStart_date().setSeconds(0);
        Timestamp startDate = new Timestamp(request.getStart_date().getTime());

        request.getEnd_date().setHours(0);
        request.getEnd_date().setMinutes(0);
        request.getEnd_date().setSeconds(0);
        Timestamp endDate = new Timestamp(request.getEnd_date().getTime());

        List<EmployeeWorkedHoursEntity> items = employeeWorkedHoursRepository.
                findAllByWorkedDateBetween(startDate, endDate);

        if (items.isEmpty()) {
            response.setPayment(null);
            response.setSuccess(false);
            return response;
        }

        List<JobsEntity> jobs = jobsRepository.findAllById(employee.get(0).getJob_id());

        if (jobs.isEmpty()) {
            response.setPayment(null);
            response.setSuccess(false);
            return response;
        }

        double mul = jobs.get(0).getSalary() * items.size();
        response.setPayment(mul);
        response.setSuccess(true);

        return response;
    }
}
