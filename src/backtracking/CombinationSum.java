package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CombinationSum {

  public static void main(String[] args) {
    System.out.println(new CombinationSum().combinationSum(new ArrayList<>(Arrays.asList(2,3,6,7)), 7));
  }

  ArrayList<ArrayList<Integer>> ans;
  public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
    Set<Integer> s = new HashSet<>(A);
    A = new ArrayList<>(s);
    Collections.sort(A);
    ans = new ArrayList<ArrayList<Integer>>();
    combination(A, new ArrayList<Integer>(), 0, 0, B);
    return ans;
  }

  public void combination(
      ArrayList<Integer> A, ArrayList<Integer> currentArr,
      int index, int currentSum, int expectedSum
  ) {
    if (currentSum > expectedSum) {
      return;
    }

    if (currentSum == expectedSum) {
      ans.add(new ArrayList<>(currentArr));
      return;
    }

    for (int i=index; i<A.size(); i++) {
      currentArr.add(A.get(i));
      currentSum += A.get(i);
      combination(A, currentArr, i, currentSum, expectedSum);
      currentSum -= A.get(i);
      currentArr.remove(currentArr.size()-1);
    }
  }
}
