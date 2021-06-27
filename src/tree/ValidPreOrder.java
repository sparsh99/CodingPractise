package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ValidPreOrder {

  public static void main(String[] args) {
    System.out.println(
        new ValidPreOrder().solve(new ArrayList<>(
            Arrays.asList(7, 7, 10, 10, 9, 5, 2, 8)
        ))
    );
  }

  public int solveNSq(ArrayList<Integer> A) {
    return checkValid(A, 0, A.size()-1);
  }

  public int checkValid(ArrayList<Integer> A, int s, int e) {

    if (s == e) {
      return 1;
    } else if (s+1 == e) {
      if (A.get(s) > A.get(e)) {
        return 1;
      } else {
        return 0;
      }
    }

    int i;
    int lastSmallest = -1;
    for (i=s+1; i<=e; i++) {
      if (lastSmallest == -1 && A.get(i) > A.get(s)) {
        lastSmallest = i-1;
      }

      if (lastSmallest != -1 && A.get(i) < A.get(s)) {
        return 0;
      }
    }

    return (checkValid(A, s, lastSmallest) == 1)
        ? checkValid(A, lastSmallest+1, e)
        : 0;
  }

  public int solve(ArrayList<Integer> A) {
    /*
        Lets say A is a pre-order.
        we iterate till decreasing elements in array.
        we reach the leftest element.
        we reach the lowest right element now. its immediate parent is marked as root.
        any left element to the right element should be greater than root.

        any array is pre-order if first element is root, subarray of all smaller or equal element
        than root is pre-order and all greater element than root is pre-order.
     */
    Stack<Integer> s = new Stack<>();
    int root = Integer.MIN_VALUE;
    for(int a: A) {
      if (a < root) { // checks any smaller number on right side of root
        return 0;
      }

      while (!s.isEmpty() && s.peek() < a) { // this iterates till all smaller elements are
        root = s.pop();
      }

      s.push(a);
    }

    return 1;
  }
}
