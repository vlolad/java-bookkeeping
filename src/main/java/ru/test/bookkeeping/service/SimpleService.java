package ru.test.bookkeeping.service;

public abstract class SimpleService {
    private Integer idCounter = 0;

    protected Integer generateId() {
        return ++idCounter;
    }
}
