package com.example.patterns2.observer.homework;

public class Mentor implements Observer {
    private final String name;
    private int taskCount;

    public Mentor(String name) {
        this.name = name;
    }

    @Override
    public void addToQueue(Student student) {
        System.out.println(name + ": new tasks from student: " + student.getName() + "\n"
        + "(In total: " + student.getTasks().size() + ")");
        taskCount++;
    }

    public String getName() {
        return name;
    }

    public int getTaskCount() {
        return taskCount;
    }
}
