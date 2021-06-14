package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class FindMaxAbsoluteDiff {

  public static void main(String[] args) {
    new FindMaxAbsoluteDiff().maxArr(new ArrayList<>(Arrays.asList(1, 3, -1)));
  }

  public int maxArr(ArrayList<Integer> A) {
    int prevMinIndex = 0;
    int maxVal = 0;
    for (int i=1; i<A.size(); i++) {
      if (A.get(i) < A.get(prevMinIndex)) {
        if(Math.abs(i - prevMinIndex) < Math.abs(A.get(prevMinIndex) - A.get(i))) {
          prevMinIndex = i;
        }
      }

      if (Math.abs(A.get(i) - A.get(prevMinIndex)) + Math.abs(i - prevMinIndex) > maxVal) {
        maxVal = Math.abs(A.get(i) - A.get(prevMinIndex)) + Math.abs(i - prevMinIndex);
      }
    }

    prevMinIndex = A.size() - 1;
    for (int i=A.size() - 2; i>=0; i--) {
      if (A.get(i) < A.get(prevMinIndex)) {
        if(Math.abs(prevMinIndex - i) < Math.abs(A.get(prevMinIndex) - A.get(i))) {
          prevMinIndex = i;
        }
      }

      if (Math.abs(A.get(i) - A.get(prevMinIndex)) + Math.abs(prevMinIndex - i) > maxVal) {
        maxVal = Math.abs(A.get(i) - A.get(prevMinIndex)) + Math.abs(prevMinIndex - i);
      }
    }

    return maxVal;
  }
}
