package com.example.patterns2.adapter.company;

import com.example.patterns2.adapter.company.oldhrsystem.Workers;
import org.junit.Assert;
import org.junit.Test;

public class SalaryAdapterTestSuite {
    @Test
    public void testTotalSalary() {
        //given
        Workers workers = new Workers();
        SalaryAdapter adapter = new SalaryAdapter();
        //when
        double totalSalary = adapter.totalSalary(workers.getWorkers(),workers.getSalaries());
        //then
        System.out.println(totalSalary);
        Assert.assertEquals(totalSalary, 14500, 0);
    }
}
