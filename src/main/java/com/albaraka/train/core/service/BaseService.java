package com.albaraka.train.core.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class BaseService<T extends BaseEntity,ID> implements CRUDService<T,ID>{

    protected abstract JpaRepository<T, ID> getRepository();

    @Override
    public T create(T t) {
        return getRepository().save(t);
    }

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public T update(T t, ID id) {
        // Varsa güncelle, yoksa exception fırlat
        if (!getRepository().existsById(id)) {
            throw new IllegalArgumentException(
                    String.format("Entity %s not found with id %s", t.getClass().getSimpleName(), id)
            );
        }
        return getRepository().save(t);
    }

    @Override
    public T findById(ID id) {
        return getRepository().findById(id).orElseGet(null);
    }

    @Override
    public void delete(ID id) {
        getRepository().deleteById(id);
    }
}
