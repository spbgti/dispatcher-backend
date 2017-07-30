package com.spbgti.dispatcherapp.service;

import java.util.List;

public interface ServiceInterface<T> {
    T add(T entity);
    void delete(long id);
    T getByName(String name);
    T edit(T entity);
    List<T> getAll();
}
