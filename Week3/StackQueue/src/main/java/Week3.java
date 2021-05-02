import com.devz.coding.bootcamp.Pollack;
import com.devz.coding.bootcamp.Solution;

public class Week3 {

    public static void main(String... args) {
        /*Stack stack = new Stack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        stack.print();

        System.out.println("min " +stack.getMin());
        stack.pop();
        System.out.println("peek " +stack.peek());
        System.out.println("min " +stack.getMin());*/


/*
        Queue myQueue = new Queue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]

        System.out.println(myQueue.empty()); // return false
 */

        System.out.println(Pollack.calculate("5+2-1+9"));
        System.out.println(new Solution().calculate("2*5/2"));

    }
}
