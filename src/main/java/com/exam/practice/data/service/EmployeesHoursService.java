package com.exam.practice.data.service;

import com.exam.practice.data.dto.AddHoursEmployeeResponse;
import com.exam.practice.data.dto.EmployeesHoursRequest;
import com.exam.practice.data.entity.EmployeeWorkedHoursEntity;
import com.exam.practice.data.repository.EmployeeWorkedHoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

/**
 * Servicio que contiene la logica de negocio para agregas horas.
 */
@Service
public class EmployeesHoursService {

    /**
     * Componente repository de Empleados.
     */
    @Autowired
    private EmployeeWorkedHoursRepository employeeWorkedHoursRepository;

    /** The constant 20. */
    private static final int MAYOR_HOURS = 20;

    /**
     * Insert hours employees add hours employee response.
     *
     * @param request the request
     * @return the add hours employee response
     */
    public AddHoursEmployeeResponse insertHoursEmployees(final EmployeesHoursRequest request) {

        AddHoursEmployeeResponse response = new AddHoursEmployeeResponse();

        if (request.getWorked_hours() > MAYOR_HOURS) {
            response.setId(null);
            response.setSuccess(false);
            return response;
        }

        LocalDate fechaWork = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd")
                .format(request.getWorked_date()));
        LocalDate dateNow = LocalDate.now();

        if (fechaWork.isAfter(dateNow)) {
            response.setId(null);
            response.setSuccess(false);
            return response;
        }

        request.getWorked_date().setHours(0);
        request.getWorked_date().setMinutes(0);
        request.getWorked_date().setSeconds(0);
        Timestamp ts = new Timestamp(request.getWorked_date().getTime());

        List<EmployeeWorkedHoursEntity> existItem = employeeWorkedHoursRepository
                .findAllByEmployeeIdAndWorkedDate(request.getEmployee_id(), ts);

        if (!existItem.isEmpty()) {
            response.setId(null);
            response.setSuccess(false);
            return response;
        }

        try {
            EmployeeWorkedHoursEntity item = new EmployeeWorkedHoursEntity();
            item.setEmployeeId(request.getEmployee_id());
            item.setWorkedHours(request.getWorked_hours());
            item.setWorkedDate(request.getWorked_date());
            EmployeeWorkedHoursEntity itemSave = employeeWorkedHoursRepository.saveAndFlush(item);
            response.setId(itemSave.getId());
            response.setSuccess(true);
        } catch (Exception ex) {
            response.setId(null);
            response.setSuccess(false);
        }

        return response;
    }
}
