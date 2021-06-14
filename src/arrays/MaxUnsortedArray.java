package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxUnsortedArray {

  public static void main(String[] args) {
    List<Integer> ans = new MaxUnsortedArray().subUnsort(
        new ArrayList<>(Arrays.asList(3, 3, 4, 5, 5, 9, 11, 13, 14, 15, 15, 16, 15, 20, 16))
    );
    System.out.println(ans.get(0) + " " + ans.get(1));
  }

  public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {

    // find first point from left where dip
    // find smallest no after dip
    // check if smallest in sorted left side and take as left index
    int leftDip = -1;
    for (int i=1; i<A.size(); i++) {
      if (A.get(i-1) > A.get(i)) {
        leftDip = i;
        break;
      }
    }

    if (leftDip == -1) {
      return new ArrayList<>(Arrays.asList(-1));
    }

    int smallestNo = Integer.MAX_VALUE;
    for (int j=leftDip; j<A.size(); j++) {
      if (A.get(j) < smallestNo) {
        smallestNo = A.get(j);
      }
    }

    int leftIndex = -1;
    for (int i=leftDip-1; i>=0; i--) {
      if (A.get(i) <= smallestNo) {
        leftIndex = i+1;
        break;
      } else if (i==0 && A.get(i) > smallestNo) {
        leftIndex = i;
        break;
      }
    }

    int rightDip = -1;
    for (int i=A.size()-1; i>0; i--) {
      if (A.get(i-1) > A.get(i)) {
        rightDip = i-1;
        break;
      }
    }

    int largestNo = Integer.MIN_VALUE;
    for (int j=0; j<=rightDip; j++) {
      if (A.get(j) > largestNo) {
        largestNo = A.get(j);
      }
    }

    int rightIndex = -1;
    for (int i=rightDip+1; i<A.size(); i++) {
      if (A.get(i) >= largestNo) {
        rightIndex = i-1;
        break;
      } else if (i==A.size()-1 && A.get(i) < largestNo) {
        rightIndex = i;
        break;
      }
    }

    return new ArrayList<>(Arrays.asList(leftIndex, rightIndex));
  }

}
