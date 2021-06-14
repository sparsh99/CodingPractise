package linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkedListMergesort {

  static class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
  }

  public static void main(String[] args) {
    List<Integer> arr = new ArrayList<>(Arrays.asList(
        90,94,25,51,45,29,55,63,48,27,72,10,36,68,16,20,31,7,95,70,89,23,22,9,74,71,35,5,
        80,11,49,92,69,6,37,84,78,28,43,64,96,57,83,13,73,97,75,59,53,52,19,18,98,12,81,
        24,15,60,79,34,1,54,93,65,44,4,87,14,67,26,30,77,58,85,33,21,46,82,76,88,66,101,61,47,8
    ));

    ListNode ans = new LinkedListMergesort().sortList(buildList(arr));
    printList(ans);
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
  }

  public ListNode sortList(ListNode start) {
    if (start == null || start.next == null) {
      return start;
    }

    ListNode slow = start;
    ListNode fast = start;
    ListNode prev = start;
    while (fast != null) {
      prev = slow;
      slow = slow.next;
      fast = (fast.next != null) ? fast.next.next : null;
    }

    ListNode secondList = prev.next;
    prev.next = null;
    start = sortList(start);
    secondList = sortList(secondList);

    ListNode sortedListHead = null;
    ListNode sortedListTail = null;
    while(start != null && secondList != null) {
      if (start.val <= secondList.val) {
        if (sortedListHead == null) {
          sortedListHead = start;
          sortedListTail = start;
        } else {
          sortedListTail.next = start;
          sortedListTail = start;
        }

        start = start.next;
        sortedListTail.next = null;
      } else {
        if (sortedListHead == null) {
          sortedListHead = secondList;
          sortedListTail = secondList;
        } else {
          sortedListTail.next = secondList;
          sortedListTail = secondList;
        }

        secondList = secondList.next;
        sortedListTail.next = null;
      }
    }

    if (start != null) {
      sortedListTail.next = start;
    } else if (secondList != null) {
      sortedListTail.next = secondList;
    }

    return sortedListHead;
  }
}
