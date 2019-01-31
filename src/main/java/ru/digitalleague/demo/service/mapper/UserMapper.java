/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2019.
 */

package ru.digitalleague.demo.service.mapper;

import ru.digitalleague.demo.domain.UserEntity;
import ru.digitalleague.demo.service.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserMapper implements EntityMapper<UserDTO, UserEntity> {
    @Override
    public UserEntity toEntity(UserDTO dto) {
        if(dto == null){
            return null;
        }
        UserEntity user = new UserEntity();
        user.setId(dto.getId());
        user.setFirstName(dto.getFirstName());
        user.setMiddleName(dto.getMiddleName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        return user;
    }

    @Override
    public UserDTO toDto(UserEntity entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<UserEntity> toEntity(List<UserDTO> dtoList) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<UserDTO> toDto(List<UserEntity> entityList) {
        throw new UnsupportedOperationException();
    }
}
