package com.exam.practice.data.repository;

import com.exam.practice.data.entity.EmployeesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<EmployeesEntity, String> {

    List<EmployeesEntity> findAllByNameAndLastName(String name, String lastName);
}
