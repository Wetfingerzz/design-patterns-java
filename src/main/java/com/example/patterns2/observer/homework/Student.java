package com.example.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Student implements Observable {
    private final String name;
    private final ArrayDeque<String> tasks;
    private final List<Observer> observers;

    public Student(String name) {
        this.name = name;
        tasks = new ArrayDeque<String>();
        observers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayDeque<String> getTasks() {
        return tasks;
    }

    public void addTask(String task) {
        tasks.offerLast(task);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.addToQueue(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
    observers.remove(observer);
    }
}
