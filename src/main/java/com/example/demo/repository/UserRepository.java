/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2018.
 */

package com.example.demo.repository;

import com.example.demo.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    List<UserEntity> findBy();
    UserEntity findByEmail(String email);
    UserEntity findById(long id);

}
