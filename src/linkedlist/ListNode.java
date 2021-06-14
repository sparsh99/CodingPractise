package linkedlist;

import java.util.List;

public class ListNode {

  public int val;
  public ListNode next;
  public ListNode(int x) {
    val = x; next = null;
  }

  public static ListNode buildList(List<Integer> arr) {
    ListNode prev = null;
    ListNode head = null;
    for (int i=0; i<arr.size(); i++) {
      ListNode newNode = new ListNode(arr.get(i));
      if (head == null) {
        head = newNode;
      } else {
        prev.next = newNode;
      }

      prev = newNode;
    }
    return head;
  }

  public static void printList(ListNode node) {
    while (node != null) {
      System.out.print(node.val);
      if (node.next != null) {
        System.out.print(" -> ");
      }
      node = node.next;
    }
    System.out.println();
  }

}
