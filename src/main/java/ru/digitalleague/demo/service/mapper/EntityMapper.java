/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2019.
 */

package ru.digitalleague.demo.service.mapper;

import java.util.List;

/**
 * Mapper interface
 *
 * @param <D> is a DTO Object
 * @param <E> is an Entity Object
 */
public interface EntityMapper<D, E> {
    public E toEntity(D dto);

    public D toDto(E entity);

    public List<E> toEntity(List<D> dtoList);

    public List<D> toDto(List<E> entityList);
}
