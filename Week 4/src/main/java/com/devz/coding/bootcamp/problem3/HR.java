package com.devz.coding.bootcamp.problem3;

import com.devz.coding.bootcamp.common.Employee;
import com.devz.coding.bootcamp.common.TreeNode;

import java.util.*;

public class HR {

    private final TreeNode hr = new TreeNode();
    private final HashMap<Employee, Employee> employeeMap = new HashMap<>();

    public void build(Integer employeeId, Integer managerId, Integer cost) {
        final Deque<Map.Entry<Employee, TreeNode>> stack = new ArrayDeque<>(hr.children.entrySet());
        while(!stack.isEmpty()) {
            Map.Entry<Employee, TreeNode> node = stack.pop();
            if(!employeeMap.containsKey(node.getKey()))
                employeeMap.put(node.getKey(), new Employee());

            if(node.getKey().employeeId.compareTo(managerId) == 0) {
                employeeMap.put(new Employee(employeeId, cost), node.getKey());

                node.getValue().children.put(new Employee(employeeId, cost), new TreeNode());
                node.getKey().isManager = true;
                return;
            } else if(node.getKey().employeeId.compareTo(employeeId) == 0) {
                Employee manager = new Employee(managerId, true, 0);
                Employee subManager= new Employee(employeeId, true, cost);

                TreeNode e = new TreeNode();
                e.children.putAll(node.getValue().children);

                TreeNode e2 = new TreeNode();
                e2.children.put(subManager, e);

                //put the subtree in the hashmap
                hr.children.put(manager, e2);

                //remove the previous node if it exists
                hr.children.remove(node.getKey());

                employeeMap.put(subManager, manager);

                return;
            }

            node.getValue().children.entrySet().forEach(stack::push);
        }

        //If the employee does not exist then create it as manager
        Employee employee = new Employee(employeeId, false, cost);
        Employee manager = new Employee(managerId, true, 0);

        employeeMap.put(employee, manager);
        hr.children.put(new Employee(managerId, true, 0), new TreeNode(employeeId, cost));
    }

    public Integer getTotalCost() {
        final Deque<Map.Entry<Employee, TreeNode>> stack = new ArrayDeque<>();
        hr.children.entrySet().forEach(stack::push);
        while(!stack.isEmpty()) {
            Map.Entry<Employee, TreeNode> node = stack.pop();
            Employee employee = new Employee(node.getKey().employeeId, node.getKey().isManager, node.getKey().cost);
            Employee managerId = getManager(employee);
            employee.totalCost = employee.cost + managerId.totalCost;
            employeeMap.remove(node.getKey());
            employeeMap.put(employee, managerId);

            node.getValue().children.entrySet().forEach(stack::push);
        }

        OptionalInt max = employeeMap.keySet().stream().mapToInt(v-> v.totalCost ).max();

        return max.isPresent() ? max.getAsInt() : 0;
    }

    private Employee getManager(Employee employee) {
        return employeeMap.keySet().stream()
                .filter(k -> k.equals(employeeMap.get(employee)))
                .findFirst()
                .orElse(new Employee());
    }
}

