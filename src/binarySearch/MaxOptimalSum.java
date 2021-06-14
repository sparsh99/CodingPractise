package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxOptimalSum {
  /*
  DOES NOT WORK
   */

  public static void main(String[] args) {
    System.out.println(
        new MaxOptimalSum().books(new ArrayList<>(Arrays.asList(73, 58, 30, 72, 44, 78, 23, 9)), 5)
    );
  }

  public int books(ArrayList<Integer> A, int B) {
    int expectedMaxSum = A.get(0);
    for(int i=1; i<A.size(); i++) {
      if (A.get(i) > expectedMaxSum) {
        expectedMaxSum = A.get(i);
      }
      A.set(i, A.get(i-1) + A.get(i));
    }

    while(expectedMaxSum < Integer.MAX_VALUE) {
      int isOptimal = isOptimalMaxPossibleSum(A, expectedMaxSum, B);
      if (isOptimal == 0) {
        break;
      } else if (isOptimal < -1) {
        expectedMaxSum = expectedMaxSum/2;
      } else {
        expectedMaxSum = expectedMaxSum*2;
      }
    }

    int maxSum = 0;
    int prevSum = 0;
    int i=0;
    while(i<A.size()) {
      while(i<A.size()-1 && A.get(i+1) - prevSum <= expectedMaxSum) {
        i++;
      }
      prevSum = A.get(i) - prevSum;
      if (prevSum > maxSum) {
        maxSum = prevSum;
      }
      i++;
    }

    return maxSum;
  }

  Integer isOptimalMaxPossibleSum(ArrayList<Integer> A, int expectedMaxSum, int B) {
    int i=0;
    int prevSum = 0;
    int totalParts = 0;
    while(i<A.size()) {
      while(i<A.size()-1 && A.get(i+1) - prevSum <= expectedMaxSum) {
        i++;
      }
      i++;
      prevSum = A.get(i-1) - prevSum;
      totalParts++;
    }
    return (totalParts == B) ? 0 : ((totalParts < B) ? -1 : 1);
  }
}
