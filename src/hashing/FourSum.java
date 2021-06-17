package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourSum {

  public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
    Collections.sort(A);
    for (int i=0; i<A.size(); i++) {
      for (int j=i+1; j<A.size(); j++) {
        int target = B - A.get(i) - A.get(j);
        int left = j+1;
        int right = A.size()-1;
        while (left <= right) {
          if (A.get(left) + A.get(right) == target) {
            while (left == A.size() - 1 || A.get(left).equals(A.get(left + 1))) {
              left++;
            }

            while (right > 0 && A.get(left).equals(A.get(right - 1))) {
              right--;
            }
          } else if (A.get(left) + A.get(right) < target) {
            left++;
          } else {
            right--;
          }
        }
      }
    }
  }
}
