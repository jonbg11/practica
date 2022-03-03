package com.exam.practice.data.repository;

import com.exam.practice.data.entity.JobsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobsRepository extends JpaRepository<JobsEntity, String> {

    boolean existsById(Integer id);

    List<JobsEntity> findAllById(Integer id);
}
