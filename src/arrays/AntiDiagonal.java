package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class AntiDiagonal {
  public static void main(String[] args) {
    Integer[][] A = new Integer[][] {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };

    ArrayList<ArrayList<Integer>> A1 = new ArrayList<>();
    for (int i=0; i<A.length; i++) {
      A1.add(new ArrayList<>(Arrays.asList(A[i])));
    }

    new AntiDiagonal().diagonal(A1);
  }

  public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
    // sum of index i+j in any anti-diagonal is fixed.
    HashMap<Integer, ArrayList<Integer>> sumToList = new HashMap<>();
    for (int i=0; i<A.size(); i++) {
      for (int j=0; j<A.size(); j++) {
        if (!sumToList.containsKey(i + j)) {
          sumToList.put(i+j, new ArrayList<Integer>());
        }

        sumToList.get(i+j).add(A.get(i).get(j));
      }
    }

    return new ArrayList<ArrayList<Integer>>(sumToList.values());
  }
}
