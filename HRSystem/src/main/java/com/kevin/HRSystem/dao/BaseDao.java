package com.kevin.HRSystem.dao;

import java.util.List;

public interface BaseDao<T> {

    void save(T entity);

    void delete(long id);

    void update(T entity);

    T findById(long id);

    List<T> findAll();
}
