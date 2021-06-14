package linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicatesSortedList {

  public static void main(String[] args) {
    List<Integer> arr = new ArrayList<>(Arrays.asList(
        1,1,1,2,2,2,2,2,2,3,3,5,5,6,7,7,7,7,7,8,8,9,10,11,11,11,11,12,12,12,
        13,13,13,14,14,14,14,14,15,16,16,17,17,17,18,18,18,18,18,18,18,
        19,19,19,19,20,20
    ));
    ListNode.printList(
        new RemoveDuplicatesSortedList().deleteDuplicates(
            ListNode.buildList(arr)
        )
    );
  }

  public ListNode deleteDuplicates(ListNode A) {
    ListNode head = null;
    ListNode tail = null;
    while(A != null) {
      ListNode first = A;
      ListNode prev = A;
      while(A != null && A.val == first.val) {
        prev = A;
        A = A.next;
      }

      if (first.next == A) { // no duplicate
        if (head == null) {
          head = first;
          tail = first;
          first.next = null;
        } else {
          tail.next = first;
          tail = tail.next;
          first.next = null;
        }
      }
    }

    return head;
  }

}
