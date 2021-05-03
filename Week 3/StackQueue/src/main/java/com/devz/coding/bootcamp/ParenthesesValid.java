package com.devz.coding.bootcamp;

import com.devz.coding.bootcamp.stack.Stack;

public class ParenthesesValid {


    public static void main(String... a) {
        /*
        S = new empty stack data structure
for x in the input sequence:
    while S is nonempty and the top element of S is greater than or equal to x:
        pop S
    if S is empty:
        x has no preceding smaller value
    else:
        the nearest smaller value to x is the top element of S
    push x onto S
         */

        char[] g = "()))((".toCharArray();
        Stack s = new Stack();

        for(int i=0; i<g.length; i++) {
            int t= g[i] == '(' ? 0 : 1;
            while(s.top != null && s.top.data >= t){
                s.pop();
            }

            if(s.top == null)
                System.out.println("x has no preceding smaller value");
            else
                System.out.println("the nearest smaller value to x is the top element of S: " + s.top.data);

            s.push(t);
        }

        s.print();
    }
}
