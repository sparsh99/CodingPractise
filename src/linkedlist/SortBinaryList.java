package linkedlist;

import java.util.List;

public class SortBinaryList {

  public static void main(String[] args) {

  }

  class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
  }

  public ListNode solve(ListNode A) {
    ListNode zeroListFirst = null;
    ListNode zeroListEnd = null;
    ListNode oneListFirst = null;
    ListNode oneListEnd = null;

    while (A != null) {
      ListNode next = A.next;
      if (A.val == 0) {
        if (zeroListEnd == null) {
          zeroListFirst = A;
          zeroListEnd = A;
        } else {
          zeroListEnd.next = A;
          A.next = null;
          zeroListEnd = A;
        }
      } else {
        if (oneListEnd == null) {
          oneListFirst = A;
          oneListEnd = A;
        } else {
          oneListEnd.next = A;
          A.next = null;
          oneListEnd = A;
        }
      }

      A = next;
    }

    if (zeroListEnd != null) {
      zeroListEnd.next = oneListFirst;
    }
    return zeroListFirst;
  }
}
