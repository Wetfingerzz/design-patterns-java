package com.example.patterns2.observer.homework;

import org.junit.Assert;
import org.junit.Test;

public class StudentTasksTestSuite {

    @Test
    public void testTasksQueue() {
        //given
        Student student1 = new Student("Michael Phelps");
        Student student2 = new Student("John Grisham");
        Student student3 = new Student("Otylia Jędrzejczak");

        Mentor mentor1 = new Mentor("XXX");
        Mentor mentor2 = new Mentor("YYY");

        student1.registerObserver(mentor1);
        student2.registerObserver(mentor1);
        student3.registerObserver(mentor2);
        //when
        student1.addTask("Design Patterns");
        student2.addTask("Stream");
        student3.addTask("Aspect Oriented Programming");
        //then
        Assert.assertEquals(mentor1.getTaskCount(),2);
        Assert.assertEquals(mentor2.getTaskCount(),1);
    }
}
