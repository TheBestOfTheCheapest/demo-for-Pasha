/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2019.
 */

package ru.digitalleague.demo.service.mapper;

import ru.digitalleague.demo.domain.AuthorityEntity;
import ru.digitalleague.demo.domain.UserEntity;
import ru.digitalleague.demo.service.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserMapper implements EntityMapper<UserDTO, UserEntity> {
    @Override
    public UserEntity toEntity(UserDTO dto) {
        if (dto == null) {
            return null;
        }
        UserEntity user = new UserEntity();
        user.setId(dto.getId());
        user.setFirstName(dto.getFirstName());
        user.setMiddleName(dto.getMiddleName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        Set<AuthorityEntity> authorities = this.authoritiesFromStrings(dto.getAuthorities());
        user.setAuthorities(authorities);
        return user;
    }

    @Override
    public UserDTO toDto(UserEntity entity) {
        if(entity == null){
            return null;
        }
        UserDTO user = new UserDTO();
        user.setId(entity.getId());
        user.setFirstName(entity.getFirstName());
        user.setLastName(entity.getLastName());
        user.setMiddleName(entity.getMiddleName());
        user.setEmail(entity.getEmail());
        user.setAuthorities(entity.getAuthorities().stream().map(AuthorityEntity::getName).collect(Collectors.toSet()));
        throw new UnsupportedOperationException();
    }

    @Override
    public List<UserEntity> toEntity(List<UserDTO> dtoList) {
        return dtoList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> toDto(List<UserEntity> entityList) {
        return entityList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private Set<AuthorityEntity> authoritiesFromStrings(Set<String> authoritiesAsStrings) {
        Set<AuthorityEntity> authorities = new HashSet<>();

        if (authoritiesAsStrings != null){
            authorities= authoritiesAsStrings.stream()
                    .map(string->{
                        AuthorityEntity auth = new AuthorityEntity();
                        auth.setName(string);
                        return auth;
                    })
                    .collect(Collectors.toSet());
        }

            return authorities;
    }
}
