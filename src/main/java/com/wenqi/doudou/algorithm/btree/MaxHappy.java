package com.wenqi.doudou.algorithm.btree;

import java.util.List;

/**
 * 在一个组织结构中，一个员工可以有若干个下级，每个员工只能有一个上级，每个员工有快乐值
 * 发请柬，发的人一定来，不发的人一定不来
 * 对于一个组织，怎么发请柬，来的人整体快乐值最大
 */
public class MaxHappy {
    static class Employee {
        int happy;
        List<Employee> nexts;

        public Employee(int happy) {
            this.happy = happy;
        }
    }

    static class Info {
        public int yes;
        public int no;

        public Info(int yes, int no) {
            this.yes = yes;
            this.no = no;
        }
    }

    public static Info process(Employee employee) {
        if (employee.nexts == null || employee.nexts.isEmpty()) {
            return new Info(employee.happy, 0);
        }
        int yes = employee.happy;
        int no = 0;
        for (Employee next : employee.nexts) {
            Info info = process(next);
            yes += info.no;
            no += Math.max(info.yes, info.no);
        }

        return new Info(yes, no);

    }

    public static void main(String[] args) {
        Employee employee = new Employee(10);
        Employee employee2 = new Employee(10);
        Employee employee3 = new Employee(10);
        Employee employee4 = new Employee(10);

        List<Employee> list = List.of(employee2, employee3, employee4);
        employee.nexts = list;

        Info process = process(employee);

        System.out.println("yes:" + process.yes + " no:" + process.no);
    }
}
