package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSum {

  public static void main(String[] args) {
    System.out.println(new ThreeSum().threeSumClosest(
        new ArrayList<>(Arrays.asList(-1, 2, 1, -4)), 1
    ));
  }

  public int threeSumClosest(ArrayList<Integer> A, int B) {
    Collections.sort(A);
    int nearestSum = Integer.MIN_VALUE;
    for (int i=0; i<A.size(); i++) {
      int left = 0;
      int right = A.size()-1;
      while (left < i && right > i) {
        int newSum = A.get(left) + A.get(right) + A.get(i);
        if (Math.abs(newSum-B) < Math.abs(nearestSum-B)) {
          nearestSum = newSum;
        }

        if (newSum < B) {
          left++;
        } else if (newSum > B) {
          right--;
        } else {
          return B;
        }
      }
    }

    return nearestSum;
  }
}
