package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FillSpiral {

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> ans = new FillSpiral().generateMatrix(4);
    for (int i=0; i<ans.size(); i++) {
      for (int j=0; j<ans.get(0).size(); j++) {
        System.out.print(ans.get(i).get(j) + " ");
      }
      System.out.println();
    }
  }

  public ArrayList<ArrayList<Integer>> generateMatrix(int A) {

    int maxLayer = (A%2==0) ? ((A/2)-1) : A/2;
    int x=1;
    Integer[][] ans = new Integer[A][A];
    for (int i=0; i<=maxLayer; i++) {

      // left to right
      int r = i;
      int c = i;
      while(c <= A-1-i) {
        ans[r][c] = x;
        x++;
        c++;
      }

      // top to bottom
      r = i+1;
      c = A-i-1;
      while(r <= A-1-i) {
        ans[r][c] = x;
        x++;
        r++;
      }

      // right to left
      r = A-1-i;
      c = A-i-2;
      while (c > i) {
        ans[r][c] = x;
        x++;
        c--;
      }

      // bottom to top
      r = A-1-i;
      c = i;
      while (r > i) {
        ans[r][c] = x;
        x++;
        r--;
      }
    }

    ArrayList<ArrayList<Integer>> ans1 = new ArrayList<>();
    for (int i=0; i<A; i++) {
      List<Integer> row = Arrays.asList(ans[i]);
      ans1.add(new ArrayList<>(row));
    }
    return ans1;
  }
}
