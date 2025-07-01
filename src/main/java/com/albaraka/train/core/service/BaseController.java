package com.albaraka.train.core.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

public abstract class BaseController<E> {
    public abstract BaseService getBaseService();

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody E e) {
        getBaseService().create(e);
        return ResponseEntity.ok(e);
    }

}
