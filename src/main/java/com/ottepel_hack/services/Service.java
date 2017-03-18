package com.ottepel_hack.services;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by iistomin on 18/03/17.
 */
@Transactional
public abstract class Service<S extends JpaRepository<T, ID>, T, ID extends Serializable> {

    protected S repository;

    public Service(S repository) {
        this.repository = repository;
    }


    public List<T> findAll() {
        return repository.findAll();
    }


    public List<T> findAll(Sort sort) {
        return repository.findAll(sort);
    }


    public Page<T> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }


    public List<T> findAll(Iterable<ID> iterable) {
        return repository.findAll(iterable);
    }


    public long count() {
        return repository.count();
    }


    public void delete(ID id) {
        repository.delete(id);
    }


    public void delete(T value) {
        repository.delete(value);
    }


    public void delete(Iterable<? extends T> iterable) {
        repository.delete(iterable);
    }


    public void deleteAll() {
        repository.deleteAll();
    }


    public <K extends T> K save(K value) {
        return repository.save(value);
    }


    public <K extends T> List<K> save(Iterable<K> iterable) {
        return repository.save(iterable);
    }


    public T findOne(ID id) {
        return repository.findOne(id);
    }


    public boolean exists(ID id) {
        return repository.exists(id);
    }


    public void flush() {
        repository.flush();
    }


    public <K extends T> K saveAndFlush(K value) {
        return repository.saveAndFlush(value);
    }


    public void deleteInBatch(Iterable<T> iterable) {
        repository.deleteInBatch(iterable);
    }


    public void deleteAllInBatch() {
        repository.deleteAllInBatch();
    }


    public T getOne(ID id) {
        return repository.getOne(id);
    }


    public <K extends T> K findOne(Example<K> example) {
        return repository.findOne(example);
    }


    public <K extends T> List<K> findAll(Example<K> example) {
        return repository.findAll(example);
    }


    public <K extends T> List<K> findAll(Example<K> example, Sort sort) {
        return repository.findAll(example, sort);
    }


    public <K extends T> Page<K> findAll(Example<K> example, Pageable pageable) {
        return repository.findAll(example, pageable);
    }


    public <K extends T> long count(Example<K> example) {
        return repository.count(example);
    }


    public <K extends T> boolean exists(Example<K> example) {
        return repository.exists(example);
    }
}