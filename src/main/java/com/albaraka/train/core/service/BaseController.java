package com.albaraka.train.core.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public abstract class BaseController<E extends BaseEntity> {
    public abstract BaseService getBaseService();

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody E e) {
        getBaseService().create(e);
        return ResponseEntity.ok(e);
    }
    @PostMapping("/update")
    public ResponseEntity update(@RequestBody E e) {
        getBaseService().update(e,e.getId());
        return ResponseEntity.ok(e);
    }

    @GetMapping("/liste")
    public ResponseEntity findAll() {
        List<E> liste = getBaseService().findAll();
        return ResponseEntity.ok(liste);
    }

}
