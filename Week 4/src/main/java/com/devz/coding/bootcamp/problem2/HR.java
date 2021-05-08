package com.devz.coding.bootcamp.problem2;

import com.devz.coding.bootcamp.common.Employee;
import com.devz.coding.bootcamp.common.TreeNode;

import java.util.*;

public class HR {

    private final TreeNode hr = new TreeNode();

    public void build(Integer employeeId, Integer managerId) {
        final Deque<Map.Entry<Employee, TreeNode>> stack = new ArrayDeque<>(hr.children.entrySet());
        while(!stack.isEmpty()) {
            Map.Entry<Employee, TreeNode> node = stack.pop();

            if(node.getKey().employeeId.compareTo(managerId) == 0) {
                node.getValue().children.put(new Employee(employeeId), new TreeNode());
                node.getKey().isManager = true;
                return;
            } else if(node.getKey().employeeId.compareTo(employeeId) == 0) {
                Employee manager = new Employee(managerId, true);
                Employee subManager= new Employee(employeeId, true);

                TreeNode e = new TreeNode();
                e.children.putAll(node.getValue().children);

                TreeNode e2 = new TreeNode();
                e2.children.put(subManager, e);

                //put the subtree in the hashmap
                hr.children.put(manager, e2);

                //remove the previous node if it exists
                hr.children.remove(node.getKey());
                return;
            }

            node.getValue().children.entrySet().forEach(stack::push);
        }

        //If the employee does not exist then create it as manager
        hr.children.put(new Employee(managerId, true), new TreeNode(employeeId));
    }

    public boolean isManager(Integer managerId, Integer employeeId) {
        final Deque<Map.Entry<Employee, TreeNode>> stack = createStack();
        hr.children.entrySet().forEach(stack::push);

        while(!stack.isEmpty()) {
            Map.Entry<Employee, TreeNode> node = stack.pop();
            if(node.getKey().employeeId.compareTo(managerId) == 0
                    && node.getKey().isManager
                    && node.getValue().children.containsKey(new Employee(employeeId))
            ) return true;

            node.getValue().children.entrySet().forEach(stack::push);
        }

        return false;
    }

    public boolean IsInManagementChain(Integer managerId, Integer employeeId) {
        final Deque<Map.Entry<Employee, TreeNode>> stack = createStack();
        boolean isManagerFound = false;
        while(!stack.isEmpty()) {
            Map.Entry<Employee, TreeNode> node = stack.pop();
            if(node.getKey().employeeId.compareTo(managerId) == 0
                    && node.getKey().isManager
                    && !isManagerFound) {
                // We found the manager then clear the stack and push its children in order to find the employeeId
                // in the chain
                stack.clear();
                node.getValue().children.entrySet().forEach(stack::push);
                isManagerFound = true;
                continue;
            } else if (isManagerFound && node.getKey().employeeId.compareTo(employeeId) == 0)
                return true;

            node.getValue().children.entrySet().forEach(stack::push);
        }

        return false;
    }

    public List<Integer> getSubEmployees(Integer employeeId) {
        final Deque<Map.Entry<Employee, TreeNode>> stack = createStack();
        final List<Integer> children = new ArrayList<>();
        boolean isEmployeeFound = false;

        while(!stack.isEmpty()) {
            Map.Entry<Employee, TreeNode> node = stack.pop();
            if(node.getKey().employeeId.compareTo(employeeId) == 0 && !isEmployeeFound) {
                // We found the employee then clear the stack and push its children in order to find the sub employees
                stack.clear();
                node.getValue().children.entrySet().forEach(stack::push);
                isEmployeeFound = true;
                continue;
            } else if(isEmployeeFound) {
                children.add(node.getKey().employeeId);
            }

            node.getValue().children.entrySet().forEach(stack::push);
        }

        return children;
    }

    private Deque<Map.Entry<Employee, TreeNode>> createStack() {
        final Deque<Map.Entry<Employee, TreeNode>> stack = new ArrayDeque<>();
        hr.children.entrySet().forEach(stack::push);

        return stack;
    }

}

