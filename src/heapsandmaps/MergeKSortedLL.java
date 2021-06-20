package heapsandmaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import linkedlist.ListNode;

public class MergeKSortedLL {

  public static void main(String[] args) {
    ListNode.printList(new MergeKSortedLL().mergeKListsNLgN(
        new ArrayList<>(Arrays.asList(
            ListNode.buildList(Arrays.asList(1,10,20)),
            ListNode.buildList(Arrays.asList(4, 11, 13)),
            ListNode.buildList(Arrays.asList(3, 8, 9))
        ))));
    ListNode.printList(new MergeKSortedLL().mergeKListsNSq(
        new ArrayList<>(Arrays.asList(
            ListNode.buildList(Arrays.asList(1,10,20)),
            ListNode.buildList(Arrays.asList(4, 11, 13)),
            ListNode.buildList(Arrays.asList(3, 8, 9))
        ))));
  }

  public ListNode mergeKListsNLgN(ArrayList<ListNode> a) {
    PriorityQueue<ListNode> pq =
        new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
    pq.addAll(a);

    ListNode head = null;
    ListNode tail = null;
    while (!pq.isEmpty()) {
      ListNode temp = pq.poll();
      if (temp.next != null) {
        pq.add(temp.next);
      }

      temp.next = null;
      if (tail == null) {
        head = temp;
        tail = temp;
      } else {
        tail.next = temp;
        tail = temp;
      }
    }

    return head;
  }

  public ListNode mergeKListsNSq(ArrayList<ListNode> a) {
    ListNode head = null;
    ListNode tail = null;
    while (true) {
      int currentMinIndex = -1;
      for (int i=0; i<a.size(); i++) {
        if (a.get(i) != null
            && (currentMinIndex == -1
            || a.get(currentMinIndex).val > a.get(i).val)
        ) {
          currentMinIndex = i;
        }
      }

      if (currentMinIndex == -1) {
        break;
      }

      head = (head == null) ? a.get(currentMinIndex) : head;
      if (tail == null) {
        tail = head;
      } else {
        tail.next = a.get(currentMinIndex);
        tail = tail.next;
      }

      a.set(currentMinIndex, a.get(currentMinIndex).next);
    }

    return head;
  }

}
