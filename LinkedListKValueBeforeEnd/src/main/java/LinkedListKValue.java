import com.devz.coding.bootcamp.MyLinkedList;

public class LinkedListKValue {

    public static void main(String... args) {
        MyLinkedList linkedList1 = new MyLinkedList();
        linkedList1.addNode(2)
                .addNode(3)
                .addNode(1)
                .addNode(4)
                .addNode(9)
                .addNode(10)
                .addNode(11);

        MyLinkedList linkedList2 = new MyLinkedList();
        linkedList2.addNode(1)
                .addNode(2)
                .addNode(3)
                .addNode(4)
                .addNode(5)
                .addNode(6)
                .addNode(7)
                .addNode(8)
                .addNode(9)
                .addNode(10);

        System.out.println(linkedList1.getKNodeBeforeEnd(2));
        System.out.println(linkedList2.getKNodeBeforeEnd(9));
    }
}
