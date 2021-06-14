package linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListCycle {

  public static void main(String args[]) {
    List<Integer> arr = new ArrayList<>(Arrays.asList(
       1, 2, 3, 4
    ));
    ListNode listNode = ListNode.buildList(arr);
    listNode.next.next.next.next = listNode.next.next;
//    System.out.println(new ListCycle().detectCycle(listNode).val);

    arr = new ArrayList<>(Arrays.asList(
        1, 2, 3, 4, 5
    ));
    listNode = ListNode.buildList(arr);
//    System.out.println(new ListCycle().detectCycle(listNode).val);

    arr = new ArrayList<>(Arrays.asList(
        1, 1
    ));
    listNode = ListNode.buildList(arr);
    listNode.next.next = listNode;
    System.out.println(new ListCycle().detectCycle(listNode).val);
  }

  public ListNode detectCycle(ListNode a) {
    ListNode slowPointer = a;
    ListNode fastPointer = a.next;

    /*Detect Loop in LinkedList by moving two pointer One fast and One slow*/
    while(slowPointer!=fastPointer){
      if(slowPointer==null || fastPointer==null || fastPointer.next==null){
        return null;
      }
      slowPointer = slowPointer.next;
      fastPointer = fastPointer.next.next;
    }

    /* If control reaches here that means there is a loop, remove all references to next pointer to nodes you have already visited.*/
    ListNode head = a;
    ListNode prev =null;
    while(head.next!=null){
      prev = head.next;
      head.next = null;
      head = prev;
    }
    return head;
  }
}
