package tree;

import java.util.ArrayList;
import java.util.Arrays;

public class ValidPreOrder {

  public static void main(String[] args) {
    System.out.println(
        new ValidPreOrder().solve(new ArrayList<>(
            Arrays.asList(7, 7, 10, 10, 9, 5, 2, 8)
        ))
    );
  }

  public int solve(ArrayList<Integer> A) {
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
}
