package linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveNthElementFromEnd {

  public static void main(String[] args) {
    List<Integer> arr = new ArrayList<>(Arrays.asList(
        1,2,3,4,5
    ));
    ListNode.printList(
        new RemoveNthElementFromEnd().removeNthFromEnd(
            ListNode.buildList(arr), 2
        )
    );
  }

  public ListNode removeNthFromEnd(ListNode A, int B) {
    int cnt = 0;
    ListNode slow = A;
    ListNode fast = A;
    while (fast != null) {
      cnt++;
      if (cnt > B+1) {
        slow = slow.next;
      }

      fast = fast.next;
    }

    if (slow == A) {
      A = A.next;
    } else {
      slow.next = slow.next.next;
    }

    return A;
  }
}
