import com.devz.coding.bootcamp.MyLinkedList;

public class LinkedListSum {

    public static void main(String... args) {
        MyLinkedList linkedList1 = new MyLinkedList();
        linkedList1.addNode(2).addNode(3).addNode(1);

        MyLinkedList linkedList2 = new MyLinkedList();
        linkedList2.addNode(6).addNode(0).addNode(3);

        MyLinkedList linkedList3 = new MyLinkedList();
        linkedList3.addNode(9).addNode(9).addNode(9);

        MyLinkedList linkedList4 = new MyLinkedList();
        linkedList4.addNode(1);

        System.out.println(linkedList1.sum(linkedList2));
        System.out.println(linkedList3.sum(linkedList4));
    }
}
