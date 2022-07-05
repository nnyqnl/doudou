package com.wenqi.doudou.AnnotationsDemo;

public class Manager extends Employee {
//        @Override
    public void setSalary(int salary) {
        System.out.println("Manager.setSalary():" + salary);
    }


    public static void main(String[] args) {
        Employee e = new Manager();
        int salary = 200;
        e.setSalary(salary);
    }
}
