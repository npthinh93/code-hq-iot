package com.codehq.iot.service.mapper;

import java.util.List;

/**
 * @author thinhnguyen on 25/03/2022
 */
public interface EntityMapper<D, E> {

    E toEntity(D dto);

    D toDto(E entity);

    List<E> toEntity(List<D> dtoList);

    List<D> toDto(List<E> entityList);
}
