package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestAP {

  public static void main(String[] args) {
    System.out.println(new LongestAP().solve(new ArrayList<>(Arrays.asList(3, 6, 9, 12))));
    System.out.println(new LongestAP().solve(new ArrayList<>(Arrays.asList(9, 4, 7, 2, 10))));
    System.out.println(new LongestAP().solve(new ArrayList<>(Arrays.asList(3))));
  }

  public int solve(final List<Integer> A) {
    int ans = 0;
    Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();
    for (int i=0; i<A.size(); i++) {
      dp.put(i, new HashMap<>());
      for (int j=0; j<i; j++) {
        Integer currDiff = A.get(i)-A.get(j);
        Integer prevLen = dp.get(j).get(currDiff);
        prevLen = (prevLen == null) ? 0 : prevLen;
        Integer currLen = dp.get(i).get(currDiff);
        if (currLen == null || currLen < prevLen + 1) {
          dp.get(i).put(currDiff, prevLen + 1);
        }

        if (ans < dp.get(i).get(currDiff)) {
          ans = dp.get(i).get(currDiff);
        }
      }
    }

    return ans + 1;
  }
}
