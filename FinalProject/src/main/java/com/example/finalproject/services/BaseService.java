package com.example.finalproject.services;

import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface BaseService<T> {
    T save(T t);
    T findById(Long id);
    List<T> findAll(PageRequest pageable);
    int deleteById(Long id);

}
