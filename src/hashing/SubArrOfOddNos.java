package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArrOfOddNos {

  public static void main(String[] args) {
    System.out.println(
        new SubArrOfOddNos().solve(new ArrayList<>(Arrays.asList(4, 3, 2, 3, 4)), 2)
    );
    System.out.println(
        new SubArrOfOddNos().solve(new ArrayList<>(Arrays.asList(5, 6, 7, 8, 9)), 3)
    );
    System.out.println(
        new SubArrOfOddNos().solve(new ArrayList<>(Arrays.asList(68, 35)), 0)
    );
    System.out.println(
        new SubArrOfOddNos().solve(new ArrayList<>(Arrays.asList(68, 35)), 1)
    );
    System.out.println(
        new SubArrOfOddNos().solve(new ArrayList<>(Arrays.asList(68, 24)), 0)
    );
  }

  // More clean code written based on solution
  public int solve(ArrayList<Integer> A, int B) {
    Map<Integer, Integer> m = new HashMap<>();
    m.put(0, 1);
    int oddCnt = 0;
    int ans = 0;
    for (int i=0; i<A.size(); i++) {
      if (A.get(i) % 2 == 1) {
        oddCnt++;
      }
      ans += m.getOrDefault(oddCnt - B, 0);
      m.put(oddCnt, m.getOrDefault(oddCnt, 0) + 1);
    }

    return ans;
  }

  public int solve1(ArrayList<Integer> A, int B) {
    ArrayList<Integer> oddPos = new ArrayList<>();
    for (int i=0; i<A.size(); i++) {
      if (A.get(i)%2 == 1) {
        oddPos.add(i);
      }
    }

    if (B == 0) {
      return (int) Math.pow(2, A.size()-oddPos.size()) - 1;
    }

    int cnt = 0;
    for (int i=0; i<oddPos.size() - B + 1; i++) {
      int left, right;

      if (i == 0) {
        left = oddPos.get(i) + 1;
      } else {
        left = oddPos.get(i) - oddPos.get(i-1);
      }

      if (i+B-1 == oddPos.size() - 1) {
        right = A.size() - oddPos.get(i+B-1);
      } else {
        right = oddPos.get(i+B) - oddPos.get(i+B-1);
      }

      cnt += left * right;
    }

    return cnt;
  }

}
