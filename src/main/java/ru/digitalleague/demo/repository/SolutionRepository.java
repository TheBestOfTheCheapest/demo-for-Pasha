/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2019.
 */

package ru.digitalleague.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.digitalleague.demo.domain.SolutionEntity;
import ru.digitalleague.demo.domain.UserEntity;

import java.util.List;
@Repository
public interface SolutionRepository extends JpaRepository<SolutionEntity, Long> {

    List<SolutionEntity> findAll();
    List<SolutionEntity> findAllByUserOrderByCreatedTime(UserEntity user);
    SolutionEntity findById(int id);
    List<SolutionEntity> findAllByUserId(int userId);
}
