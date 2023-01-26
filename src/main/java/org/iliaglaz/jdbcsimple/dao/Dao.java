package org.iliaglaz.jdbcsimple.dao;

public interface Dao<V, T> {

    T save(T entity);
}
