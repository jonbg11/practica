package com.exam.practice.data.repository;

import com.exam.practice.data.entity.GendersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GendersRepository extends JpaRepository<GendersEntity, String> {
}
