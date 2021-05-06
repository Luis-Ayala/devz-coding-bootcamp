package com.devz.coding.bootcamp.problem2;

import java.util.Objects;

public class Employee {
    public Integer employeeId;
    public boolean isManager;

    public Employee(Integer employeeId, boolean isManager) {
        this.employeeId = employeeId;
        this.isManager = isManager;
    }

    public Employee(Integer employeeId) {
        this(employeeId, false);
    }

    @Override
    public String toString() {
        return "[employeeId: " + employeeId + " isManager: " + isManager  + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId.compareTo(employee.employeeId) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }
}
