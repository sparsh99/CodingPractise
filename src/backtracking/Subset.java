package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Subset {

  public static void main(String[] args) {
    System.out.println(
        new Subset().subsets(new ArrayList<>(
            Arrays.asList(1,2,3)
        ))
    );
  }

  public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
    Collections.sort(A);
    return subsets(A, 0);
  }

  public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A, int index) {
    if (index == A.size()) {
      return new ArrayList<ArrayList<Integer>>(
          Arrays.asList(
              new ArrayList<>()
          )
      );
    }

    ArrayList<ArrayList<Integer>> child = subsets(A, index+1);
    ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
    ans.add(new ArrayList<Integer>());
    for (int i=0; i<child.size(); i++){
      ArrayList<Integer> newS = new ArrayList<>();
      newS.add(A.get(index));
      newS.addAll(child.get(i));
      ans.add(newS);
    }
    child.remove(0);
    ans.addAll(child);
    return ans;
  }

  /**
   * Alternative, more clean
   */
  public ArrayList<ArrayList<Integer>> subsetsClean(ArrayList<Integer> a) {
    ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
    output.add(new ArrayList<Integer>());
    if (a.size() == 0)
      return output;
    Collections.sort(a);
    generate(a, output, new ArrayList<Integer>(), 0);
    return output;
  }

  public void generate(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> output, ArrayList<Integer> temp, int index)
  {
    for (int i = index; i < a.size(); i++)
    {
      temp.add(a.get(i));
      output.add(new ArrayList<Integer>(temp));
      generate(a, output, temp, i+1);
      temp.remove(temp.size() - 1);
    }
  }

}
