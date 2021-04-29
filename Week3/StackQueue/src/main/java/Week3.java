import com.devz.coding.bootcamp.Stack;

public class Week3 {

    public static void main(String... args) {
        Stack stack = new Stack();

        stack.push(0);
        stack.push(1);
        stack.push(0);
        stack.print();

        System.out.println("min " +stack.getMin());

        stack.pop();
        //System.out.println("peek " +stack.peek());
        System.out.println("min " +stack.getMin());
    }
}
