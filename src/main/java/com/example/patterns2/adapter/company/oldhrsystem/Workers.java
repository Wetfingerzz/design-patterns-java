package com.example.patterns2.adapter.company.oldhrsystem;

public class Workers {
    private String[][] workers = {
            {"950101245566", "John", "Smith"},
            {"920202333762", "Max", "Min"},
            {"90121245144", "Yvette", "Xerox"}
    };
    private double[] salaries = {
            6500.00,
            3500.00,
            4500.00,
    };
    public String getWorker(int n) {
        if (n>salaries.length) {
            return "";
        }
        return workers[n][0] + ", " + workers [n] [1] + ", " + workers[n][2] + ", " + salaries[n];
    }

    public String[][] getWorkers() {
        return workers;
    }

    public double[] getSalaries() {
        return salaries;
    }
}
