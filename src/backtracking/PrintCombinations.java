package backtracking;

import java.util.ArrayList;

public class PrintCombinations {

  private ArrayList<ArrayList<Integer>> ans;

  public static void main(String[] args) {
    System.out.println(new PrintCombinations().combine(4, 2));
  }

  public ArrayList<ArrayList<Integer>> combine(int A, int B) {
    ans = new ArrayList<ArrayList<Integer>>();
    combine(1, A, B, new ArrayList<>());
    return ans;
  }

  public void combine(int min, int max, int b, ArrayList<Integer> current) {
    if (b==0) {
      ans.add(new ArrayList<>(current));
      return;
    }

    for (int i=min; i<=max-b+1; i++) {
      current.add(i);
      combine(i+1, max, b-1, current);
      current.remove(current.size()-1);
    }
  }

}
