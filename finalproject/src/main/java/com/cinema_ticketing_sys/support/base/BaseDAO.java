package com.cinema_ticketing_sys.support.base;

import org.hibernate.criterion.Criterion;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by huitianrui on 2017/5/11.
 */
public interface BaseDAO<T> {
    void save(T t);

    T get(Serializable id);

    void delete(T entity);

    void delete(Class<T> entityClazz , Serializable id);

    List<T> findAll();

    List<T> findByPage(Integer start, Integer rows);

    T findByUnique(String propertyName, Object value);

    List<T> findBy(String propertyName, Object value);

    List<T> find(String hql, Object... args);

    List<T> find(String hql, Map<String, Object> map);

    T findUnique(String hql, Object... args);

    T findUnique(String hql, Map<String, Object> map);

    List<T> find(Criterion... criterions);
}
