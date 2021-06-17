package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {

  public static void main(String[] args) {
    System.out.println(new Permutations().permute(new ArrayList<>(Arrays.asList(
        1,2,3
    ))));
  }

  ArrayList<ArrayList<Integer>> ans;
  public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
    ans = new ArrayList<ArrayList<Integer>>();
    permuteRecursive(A, 0);
    return ans;
  }

  public void permuteRecursive(
      ArrayList<Integer> A, int index
  ) {
    if (index == A.size()) {
      ans.add(new ArrayList<>(A));
      return;
    }

    for (int i=index; i<A.size(); i++) {
      int x = A.get(i);
      A.set(i, A.get(index));
      A.set(index, x);
      permuteRecursive(A, index+1);
      A.set(index, A.get(i));
      A.set(i, x);
    }
  }
}
