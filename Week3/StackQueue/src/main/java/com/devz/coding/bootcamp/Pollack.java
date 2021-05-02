package com.devz.coding.bootcamp;

import com.devz.coding.bootcamp.stack.GenericStack;

public class Pollack {

    public static Integer calculate(final String number) {
        final GenericStack<String> stack = new GenericStack<>();
        final GenericStack<String> parsedInput = parseInput(number.replace(" ", ""));
        GenericStack.Node<String> current = parsedInput.top;
        
        while(current != null) {
            if(isNumeric(current.data)) {
                stack.push(String.valueOf(current.data));
            } else {
                if(current.data.equals("+") || current.data.equals("-")) {
                    stack.push(current.data);
                } else if (current.data.equals("*") || current.data.equals("/")) {
                    String value1 = stack.pop();
                    String value2 = String.valueOf(current.next.data);
                    Integer result = performAction(current.data, value1, value2);
                    stack.push(result.toString());
                    current = current.next.next;
                    continue;
                }
            }

            current = current.next;
        }

        reverseStack(stack);
        while(stack.size != 1) {
            String value1 = stack.pop();
            String function = stack.pop();
            String value2 = stack.pop();
            Integer result = performAction(function, value1, value2);
            stack.push(result.toString());
        }

        return Integer.parseInt(stack.peek());
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Integer d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private static GenericStack<String> parseInput(String input) {
        char[] inputAsChar = input.toCharArray();
        GenericStack<String> stack = new GenericStack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : inputAsChar) {
            if (Character.isDigit(c)) {
                sb.append(c);
                continue;
            }

            stack.push(sb.toString());
            stack.push(String.valueOf(c));
            sb.setLength(0);
        }

        stack.push(sb.toString());

        return reverseStack(stack);
    }

    private static GenericStack<String> reverseStack(GenericStack<String> stack) {
        GenericStack.Node<String> tmp;
        GenericStack.Node<String> prevNode = stack.top;
        GenericStack.Node<String> currNode = stack.top.next;

        while (currNode != null) {
            tmp = currNode.next;

            if(prevNode.equals(stack.top)) {
                prevNode.next = null;
            }

            currNode.next = prevNode;
            prevNode = currNode;
            currNode = tmp;
        }
        stack.top = prevNode;
        
        return stack;
    }

    private static Integer performAction(String function, String value1, String value2) {
        Integer operand1 = Integer.valueOf(value1);
        Integer operand2 = Integer.valueOf(value2);

        switch (function) {
            case "+":
                return operand1 + operand2;

            case "-":
                return operand1 - operand2;

            case "*":
                return operand1 * operand2;

            case "/":
                return operand1 / operand2;
        }

        return 0;
    }
}
