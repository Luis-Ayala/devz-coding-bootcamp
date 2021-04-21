import java.util.HashMap;
import java.util.Map;

public class LinkedListDuplicates {
    public static void main(String... args) {
        final ListNode linkedList1 = new ListNode(4,
                new ListNode(5,
                new ListNode(9,
                new ListNode(0,
                new ListNode(5,
                new ListNode(1,
                new ListNode(2
                )))))));

        final ListNode linkedList2 = new ListNode(1,
                new ListNode(2,
                new ListNode(3,
                new ListNode(3,
                new ListNode(2,
                new ListNode(1
                ))))));

        System.out.println(linkedList1);
        System.out.println(removeDuplicates(linkedList1));

        System.out.println();

        System.out.println(linkedList2);
        System.out.println(removeDuplicates(linkedList2));
    }

    public static ListNode removeDuplicates(final ListNode node) {
        final Map<Integer, ListNode> cache = new HashMap<>();
        ListNode prevNode = node;
        ListNode currNode = node;
        while(currNode.next != null) {
            if(! cache.containsKey(currNode.value)) {
                cache.put(currNode.value, currNode);
                prevNode = currNode;
                currNode = currNode.next;
                continue;
            }

            prevNode.next = currNode.next;
            prevNode = currNode;
            currNode = currNode.next;

        }

        return node;
    }

    private static class ListNode {
        int value;
        ListNode next;

        ListNode(final int value) {
            this.value = value;
        }

        ListNode(final int value, final ListNode next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            ListNode currNode = this;
            while(currNode.next != null) {
                sb.append(currNode.value);
                currNode = currNode.next;
                if(currNode.next != null)
                    sb.append("->");
            }
            return sb.toString();
        }
    }
}
