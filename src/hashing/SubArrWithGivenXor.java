package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArrWithGivenXor {

  public static void main(String[] args) {
    System.out.println(
        new SubArrWithGivenXor().solve(
            new ArrayList<>(Arrays.asList(4, 2, 2, 6, 4)),
            6
        )
    );

    System.out.println(
        new SubArrWithGivenXor().solve(
            new ArrayList<>(Arrays.asList(5, 6, 7, 8, 9)),
            5
        )
    );
  }

  public int solve(ArrayList<Integer> A, int B) {
    int totCnt = 0;
    Map<Integer, Integer> xorCnt = new HashMap<>();
    xorCnt.put(0, 1);
    int xor = 0;
    for (int i=0; i<A.size(); i++) {
      xor = xor ^ A.get(i);

      if (!xorCnt.containsKey(xor)) xorCnt.put(xor, 1);
      else xorCnt.put(xor, xorCnt.get(xor) + 1);

      if (xorCnt.containsKey(B^xor)) {
        totCnt += xorCnt.get(B^xor);
      }
    }

    return totCnt;
  }

}
