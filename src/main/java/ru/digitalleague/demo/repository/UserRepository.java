/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2019.
 */

package ru.digitalleague.demo.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.digitalleague.demo.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findAll();
    UserEntity findByEmail(String email);
    UserEntity findById(long id);
    Boolean existsByEmail(String email);
    UserEntity findAllByFirstNameAndLastName(String firstName, String LastName);
    @EntityGraph(attributePaths = "authorities")
    UserEntity findOneWithAuthoritiesByEmail(String email);

}
