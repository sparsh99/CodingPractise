package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class LargestPermutation {

  public static void main(String[] args) {
    System.out.println(new LargestPermutation().solve(
        new ArrayList<>(Arrays.asList(3, 2, 4, 1, 5)), 3
    ));
  }

  public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
    int[] pos = new int[A.size() + 1];
    for (int i=0; i<A.size(); i++) {
      pos[A.get(i)] = i;
    }

    for (int i=0; i<A.size(); i++) {
      int expected = A.size() - i;
      if (expected != A.get(i)) {
        int t = A.get(i);
        A.set(i, expected);
        A.set(pos[expected], t);
        pos[t] = pos[expected];
        pos[expected] = i;
        B--;
      }

      if (B==0) {
        break;
      }
    }

    return A;
  }
}
