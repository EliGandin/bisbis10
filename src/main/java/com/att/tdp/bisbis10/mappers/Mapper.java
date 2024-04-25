package com.att.tdp.bisbis10.mappers;

public interface Mapper<E, T> {
    T mapTo(E e);
    E mapFrom(T t);
}
