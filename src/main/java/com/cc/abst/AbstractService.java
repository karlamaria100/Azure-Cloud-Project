package com.cc.abst;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Karla on 11-Jan-18.
 */
public abstract class AbstractService<T, PK extends Serializable> {

    public abstract GenericRepository<T, PK> getDao();

    public T add(T obj) {
        return getDao().save(obj);
    }

    public void update(T obj) {
        getDao().save(obj);
    }

    public T selectId(PK id) {
        return getDao().findOne(id);
    }

    public void delete(PK id) {
        getDao().delete(id);
    }

    public List<T> selectAll() {
        return getDao().findAll();
    }

}