package heapsandmaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxSumCombinations {

  public static void main(String[] args) {
//    System.out.println(
//        new MaxSumCombinations().solve(
//            new ArrayList<>(Arrays.asList(3, 2)),
//            new ArrayList<>(Arrays.asList(1, 4)),
//            2
//        )
//    );
//
//    System.out.println(
//        new MaxSumCombinations().solve(
//            new ArrayList<>(Arrays.asList(1, 4, 2, 3)),
//            new ArrayList<>(Arrays.asList(2, 5, 1, 6)),
//            4
//        )
//    );

    System.out.println(
        new MaxSumCombinations().solve(
            new ArrayList<>(Arrays.asList(68, 35)),
            new ArrayList<>(Arrays.asList(68, 35)),
            1
        )
    );
  }

  public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    Collections.sort(A);
    Collections.sort(B);
    for (int i=A.size()-1; i>=0; i--) {
      for (int j=B.size()-1; j>=0; j--) {
        if (pq.size() < C) {
          pq.add(A.get(i) + B.get(j));
        } else if (pq.peek() < A.get(i) + B.get(j)) {
          pq.poll();
          pq.add(A.get(i) + B.get(j));
        } else {
          break;
        }
      }
    }

    ArrayList<Integer> ans = new ArrayList<>(pq);
    Collections.sort(ans, Comparator.reverseOrder());
    return ans;
  }
}
