package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PairWithDifference {

  public static void main(String[] args) {
    // Remember sum can be negative
    System.out.println(new PairWithDifference().solve(
        new ArrayList<>(Arrays.asList(5, 10, 3, 2, 50, 80)), 78
    ));
    System.out.println(new PairWithDifference().solve(
        new ArrayList<>(Arrays.asList(-10, 20)), 30
    ));
    System.out.println(new PairWithDifference().solveTwoPointer(
        new ArrayList<>(Arrays.asList(5, 10, 3, 2, 50, 80)), 78
    ));
    System.out.println(new PairWithDifference().solveTwoPointer(
        new ArrayList<>(Arrays.asList(-10, 20)), 30
    ));
  }

  public int solve(ArrayList<Integer> A, int B) {
    B = (B<0) ? B*-1 : B;
    Map<Integer, Boolean> mp = new HashMap<>();
    for (int i=0; i<A.size(); i++) {
      // x-y = B or y-x = B => x = B+y or x=y-B

      if(mp.containsKey(B+A.get(i))
          || mp.containsKey(A.get(i)-B)) {
        return 1;
      } else {
        mp.put(A.get(i), true);
      }
    }

    return 0;
  }

  public int solveTwoPointer(ArrayList<Integer> A, int B) {
    // Remember sum can be negative
    // left is allowed to be greater than right because sum could be negative.
    Collections.sort(A);
    int left = 0;
    int right = 1;
    while (left < A.size() && right < A.size()) {
      if (A.get(right) - A.get(left) == B && right!=left) {
        return 1;
      }

      if (A.get(right) - A.get(left) < B) {
        right++;
      } else {
        left++;
      }
    }
    return 0;
  }

}
