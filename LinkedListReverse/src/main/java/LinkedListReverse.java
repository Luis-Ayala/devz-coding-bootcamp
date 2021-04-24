import om.devz.coding.bootcamp.MyLinkedList;

public class LinkedListReverse {

    public static void main(String... args) {
        MyLinkedList list = new MyLinkedList();

        list.addNode(6);
        list.addNode(8);
        list.addNode(0);
        list.addNode(4);
        list.addNode(7);
        list.addNode(2);

        list.printLikedList();
        list.reverse();
        list.printLikedList();
    }
}
