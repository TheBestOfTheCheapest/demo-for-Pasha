/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2019.
 */

package ru.digitalleague.demo.repository;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.Query;
import ru.digitalleague.demo.domain.SolutionEntity;
import ru.digitalleague.demo.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolutionRepository extends JpaRepository<SolutionEntity, Long> {

    List<SolutionEntity> findAll();
    List<SolutionEntity> findAllByUser(UserEntity user);
    SolutionEntity findById(int id);



}
