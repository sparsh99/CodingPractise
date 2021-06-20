package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourSum {

  public static void main(String[] args) {
    System.out.println(
        new FourSum().fourSum(new ArrayList<>(Arrays.asList(
            9, -8, -10, -7, 7, -8, 2, -7, 4, 7, 0, -3, -4, -5, -1, -4, 5, 8, 1,
            9, -2, 5, 10, -5, -7, -1, -6, 4, 1, -5, 3, 8, -4, -10, -9, -3, 10,
            0, 7, 9, -8, 10, -9, 7, 8, 0, 6, -6, -7, 6, -4, 2, 0, 10, 1, -2, 5, -2
        )), 0)
    );
  }

  public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
    Collections.sort(A);
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    for (int i=0; i<A.size(); i++) {
      if (i > 0 && A.get(i).equals(A.get(i-1))) {
        continue;
      }
      for (int j=i+1; j<A.size(); j++) {
        if (j > i+1 && A.get(j).equals(A.get(j-1))) {
          continue;
        }
        int target = B - A.get(i) - A.get(j);
        int left = j+1;
        int right = A.size()-1;
        while (left < right) {
          if (A.get(left) + A.get(right) == target) {
            if (!(ans.size() > 0
                && ans.get(ans.size() - 1).get(0).equals(A.get(i))
                && ans.get(ans.size() - 1).get(1).equals(A.get(j))
                && ans.get(ans.size() - 1).get(2).equals(A.get(left))
                && ans.get(ans.size() - 1).get(3).equals(A.get(right))
            )) {
              ans.add(new ArrayList<>(
                  Arrays.asList(A.get(i), A.get(j), A.get(left), A.get(right))));
            }

            left++;
            right--;
          } else if (A.get(left) + A.get(right) < target) {
            left++;
          } else {
            right--;
          }
        }
      }
    }

    return ans;
  }
}
