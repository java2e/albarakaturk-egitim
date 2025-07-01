package com.albaraka.train.core.service;

import java.util.List;

public interface CRUDService <T,ID>{


    T create(T t);

    T findById(ID id);

    List<T> findAll();


    T update(T t,ID id);


    void delete(ID id);





}
