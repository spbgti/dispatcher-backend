package com.spbgti.dispatcherapp.Service;

import java.util.List;

public interface ServiceInterface<T> {
    T add(T t);
    void delete(long id);
    T getByName(String name);
    T edit(T t);
    List<T> getAll();
}
