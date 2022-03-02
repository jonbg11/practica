package com.exam.practice.data.service;

import com.exam.practice.data.dto.AddHoursEmployeeResponse;
import com.exam.practice.data.dto.EmployeesHoursRequest;
import com.exam.practice.data.entity.EmployeeWorkedHoursEntity;
import com.exam.practice.data.repository.EmployeeWorkedHoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        List<EmployeeWorkedHoursEntity> existItem = employeeWorkedHoursRepository
                .findAllByEmployeeId(request.getEmployee_id());

        if (!existItem.isEmpty()) {
            LocalDate fechaWorkBd = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd")
                    .format(existItem.get(0).getWorkedDate()));
            if (fechaWorkBd.isEqual(fechaWork)) {
                response.setId(null);
                response.setSuccess(false);
                return response;
            }
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
