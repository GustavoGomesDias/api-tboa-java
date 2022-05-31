package com.api.tboa.DAO.generic;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T extends Serializable> {
    public T findOne(long id);
    public List<T> findAll();
    public void create(T entity);
    public void update(T entity);
    public void delete(long id);
}
