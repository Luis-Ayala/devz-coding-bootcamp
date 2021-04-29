import com.devz.coding.bootcamp.LinkedList;

public class Week2 {

    public static void main(String... args) {
        /*LinkedList list = new LinkedList();
        list.append(5);
        list.append(9);
        list.append(10);

        list.print();

        list.insert(0, 4);
        list.print();
        list.insert(3, 6);
        list.print();
        list.insert(5, 1);
        list.print();
        list.insert(10, 2);
        list.print();

        list.remove(4);
        list.print();

        list.remove(0);
        list.print();

        list.remove(3);
        list.print();

        LinkedList list2 = new LinkedList();
        list2.append(5);
        list2.remove(0);
        list2.print();

        list2.reverse();
        list2.print();

        LinkedList list3 = new LinkedList();
        list3.append(6);
        list3.append(8);
        LinkedList.Node node = list3.append(0);
        list3.append(4);
        list3.append(7);
        list3.append(2);
        list3.append(5);
        list3.append(3);
        list3.append(10, node);
        System.out.println(list3.hasCycleReference());*/

/*
        LinkedList linkedList1 = new LinkedList();
        linkedList1.append(2);
        linkedList1.append(3);
        linkedList1.append(1);

        LinkedList linkedList2 = new LinkedList();
        linkedList2.append(6);
        linkedList2.append(0);
        linkedList2.append(3);

        LinkedList linkedList3 = new LinkedList();
        linkedList3.append(9);
        linkedList3.append(9);
        linkedList3.append(9);

        LinkedList linkedList4 = new LinkedList();
        linkedList4.append(1);

        linkedList1.sum(linkedList2).print();
        linkedList3.sum(linkedList4).print();


        LinkedList linkedList11 = new LinkedList();
        linkedList11.append(2);
        linkedList11   .append(3);
        linkedList11     .append(1);
        linkedList11     .append(4);
        linkedList11      .append(9);
        linkedList11      .append(10);
        linkedList11      .append(11);;



        System.out.println(linkedList11.getKNodeBeforeEnd(-1));
        System.out.println(linkedList22.getKNodeBeforeEnd(0));*/

       /* LinkedList linkedList22 = new LinkedList();
        linkedList22.append(1);
        linkedList22.append(2);
        LinkedList.Node remove = linkedList22.append(3);
        linkedList22.append(4);
        linkedList22.append(5);
        linkedList22.print();

        linkedList22.removeNode(remove);
        linkedList22.print();*/



        // Cycle detection
        LinkedList cycleReference = new LinkedList();
        cycleReference.append(6);
        cycleReference.append(8);
        LinkedList.Node node = cycleReference.append(0);
        cycleReference.append(4);
        cycleReference.append(7);
        cycleReference.append(2);
        cycleReference.append(5);
        cycleReference.append(3);
        cycleReference.append(10, node);

        System.out.println(cycleReference.hasCycleReference());
        System.out.println(cycleReference.floydCycleDetection());
        System.out.println(cycleReference.brentCycleDetection());
    }
}
