package com.kezhuanzhai;

import org.springframework.beans.BeansException;

@FunctionalInterface
public interface SunFunction<T> {

    T getObject() throws BeansException;
}
