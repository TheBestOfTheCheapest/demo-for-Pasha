/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2019.
 */

package com.example.demo.service.mapper;

import com.example.demo.domain.SolutionEntity;
import com.example.demo.domain.TaskEntity;
import com.example.demo.domain.UserEntity;
import com.example.demo.service.dto.SolutionDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolutionMapper implements EntityMapper<SolutionDTO, SolutionEntity> {
    @Override
    public SolutionEntity toEntity(SolutionDTO dto) {
        if (dto == null) {
            return null;
        }
        SolutionEntity solution = new SolutionEntity();
        solution.setId(dto.getId());
        solution.setTask(new TaskEntity(dto.getTaskId()));
        solution.setSolutionValue(dto.getSolutionValue());
        solution.setTestResult(dto.getTestResult());
        solution.setUser(new UserEntity(dto.getUserId()));

        return solution;
    }

    @Override
    public SolutionDTO toDto(SolutionEntity entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<SolutionEntity> toEntity(List<SolutionDTO> dtoList) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<SolutionDTO> toDto(List<SolutionEntity> entityList) {
        throw new UnsupportedOperationException();
    }
}
