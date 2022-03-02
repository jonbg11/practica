package com.exam.practice.data.repository;

import com.exam.practice.data.entity.EmployeeWorkedHoursEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeWorkedHoursRepository extends JpaRepository<EmployeeWorkedHoursEntity, String> {
}
