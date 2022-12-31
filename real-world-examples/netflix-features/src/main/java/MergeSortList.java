import java.util.ArrayList;
import java.util.List;

public class MergeSortList {
    public static LinkedListNode merge2Country(LinkedListNode l1, LinkedListNode l2) {
        LinkedListNode dummy = new LinkedListNode(-1);

        LinkedListNode prev = dummy;
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        if (l1 == null)
            prev.next = l2;
        else
            prev.next = l1;

        return dummy.next;
    }

    public static LinkedListNode mergeKCounty(List<LinkedListNode> lists) {

        if (lists.size() > 0) {
            LinkedListNode res = lists.get(0);

            for (int i = 1; i < lists.size(); i++)
                res = merge2Country(res, lists.get(i));

            return res;
        }
        return new LinkedListNode(-1);
    }

    public static void main(String[] args) {

        LinkedListNode a = LinkedList.createLinkedList(new int[]{11, 41, 51});

        LinkedListNode b = LinkedList.createLinkedList(new int[]{21, 23, 42});

        LinkedListNode c = LinkedList.createLinkedList(new int[]{25, 56, 66, 72});

        List<LinkedListNode> list1 = new ArrayList<LinkedListNode>();
        list1.add(a);
        list1.add(b);
        list1.add(c);

        System.out.print("All movie ID's from best to worse are:\n");
        LinkedList.display(mergeKCounty(list1));
    }
}