package linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckPalindrome {

  public static void main(String[] args) {
    List<Integer> arr = new ArrayList<>(Arrays.asList(
        1,2,1
    ));
    System.out.println(
        new CheckPalindrome().lPalin(
            ListNode.buildList(arr)
        )
    );

    arr = new ArrayList<>(Arrays.asList(
        1,1
    ));
    System.out.println(
        new CheckPalindrome().lPalin(
            ListNode.buildList(arr)
        )
    );

    arr = new ArrayList<>(Arrays.asList(
        1,2,2,1
    ));
    System.out.println(
        new CheckPalindrome().lPalin(
            ListNode.buildList(arr)
        )
    );

    arr = new ArrayList<>(Arrays.asList(
        1,2,3,1
    ));
    System.out.println(
        new CheckPalindrome().lPalin(
            ListNode.buildList(arr)
        )
    );
  }

  public int lPalin(ListNode A) {
    int cnt = 0;
    ListNode B = A;
    while (B != null) {
      cnt++;
      B = B.next;
    }

    B = A;
    for (int i=0; i<cnt/2; i++) {
      if (i == (cnt/2 - 1)) {
        ListNode next = B.next;
        B.next = null;
        B = next;
      } else {
        B = B.next;
      }
    }

    if (cnt%2 == 1) {
      B = B.next;
    }

    // reverse B
    ListNode prev = null;
    while(B != null) {
      ListNode next = B.next;
      B.next = prev;
      prev = B;
      B = next;
    }

    // compare
    B = prev;
    while (A != null && B != null) {
      if (A.val != B.val) {
        return 0;
      }
      A = A.next;
      B = B.next;
    }

    return 1;
  }
}
