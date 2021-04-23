import com.devz.coding.bootcamp.MyLinkedList;

public class LinkedListCycleDetection {

    public static void main(String... args) {
        MyLinkedList list = new MyLinkedList();
        list.addNode(6);
        list.addNode(8);
        MyLinkedList.Node node = list.addNode(0);
        list.addNode(4);
        list.addNode(7);
        list.addNode(2);
        list.addNode(5);
        list.addNode(3);
        list.addNode(10, node);

        System.out.println(list.hasCycle());

        list.clear();
        list.addNode(6);
        list.addNode(8);
        list.addNode(0);
        list.addNode(4);
        list.addNode(7);
        list.addNode(2);

        System.out.println(list.hasCycle());
    }
}
