package linkedlist;

public class PartitionList {

  class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
  }


  public ListNode partition(ListNode A, int B) {
    ListNode leftStart = null;
    ListNode leftEnd = null;
    ListNode rightStart = null;
    ListNode rightEnd = null;

    while (A != null) {
      if (A.val < B) {
        if (leftStart == null) {
          leftStart = A;
          leftEnd = A;
        } else {
          leftEnd.next = A;
          leftEnd = A;
        }
      } else {
        if (rightStart == null) {
          rightStart = A;
          rightEnd = A;
        } else {
          rightEnd.next = A;
          rightEnd = A;
        }
      }

      ListNode next = A.next;
      A.next = null;
      A = next;
    }

    if (leftEnd == null) {
      return rightStart;
    } else {
      leftEnd.next = rightStart;
      return leftStart;
    }
  }
}
