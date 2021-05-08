package com.devz.coding.bootcamp.common;

import java.util.Objects;

public class Employee {
    public Integer employeeId;
    public boolean isManager;
    public Integer cost;
    public Integer totalCost;

    public Employee(Integer employeeId, boolean isManager, Integer cost, Integer totalCost) {
        this.employeeId = employeeId;
        this.isManager = isManager;
        this.cost = cost;
        this.totalCost = totalCost;
    }

    public Employee(Integer employeeId, boolean isManager, Integer cost) {
        this(employeeId, isManager, cost, 0);
    }

    public Employee() {
        this(null, false, 0);
    }

    public Employee(Integer employeeId, Integer cost) {
        this(employeeId, false, cost);
    }

    @Override
    public String toString() {
        return "[employeeId: " + employeeId + " isManager: " + isManager  + ", cost: " + cost + ", totalCost: " + totalCost + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        if(employeeId == null || employee.employeeId == null) return false;
        return employeeId.compareTo(employee.employeeId) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }
}
