package linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReorderList {

  public static void main(String[] args) {
    List<Integer> arrOdd = new ArrayList<>(Arrays.asList(
        1, 2, 3, 4, 5
    ));

    List<Integer> arrEven = new ArrayList<>(Arrays.asList(
        1, 2, 3, 4, 5, 6
    ));

    ListNode.printList(new ReorderList().reorderList(ListNode.buildList(arrOdd)));
    ListNode.printList(new ReorderList().reorderList(ListNode.buildList(arrEven)));
  }

  public ListNode reorderList(ListNode A) {
    int cnt = 0;
    ListNode B = A;
    while (A != null) {
      cnt++;
      A = A.next;
    }

    A = B;
    int mid = ((cnt % 2 == 0) ? cnt/2 : cnt/2 + 1);
    for (int i=0; i<mid; i++) {
      if (i == mid-1) {
        ListNode temp = B.next;
        B.next = null;
        B = temp;
      } else {
        B = B.next;
      }
    }

    // Reverse B
    ListNode prev = null;
    while(B != null) {
      ListNode next = B.next;
      B.next = prev;
      prev = B;
      B = next;
    }
    B = prev;

    // merge both arr
    ListNode ans = A;
    ListNode ansTail = null;
    while (A != null) {
      if (ansTail != null) {
        ansTail.next = A;
      }

      ListNode ANext = A.next;
      A.next = B;
      A = ANext;
      ansTail = B;

      if (B != null) {
        ListNode BNext  = B.next;
        B.next = null;
        B = BNext;
      }
    }

    return ans;
  }
}
