/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2018.
 */

package com.example.demo.repository;

import com.example.demo.domain.SolutionEntity;
import com.example.demo.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolutionRepository extends JpaRepository<SolutionEntity, Long> {

    List<SolutionEntity> findAll();
    List<SolutionEntity> findAllByUser(UserEntity user);
    SolutionEntity findById(int id);



}
