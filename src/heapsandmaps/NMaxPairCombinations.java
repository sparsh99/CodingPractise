package heapsandmaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NMaxPairCombinations {

  public static void main(String[] args) {
    System.out.println(
        new NMaxPairCombinations().solve(
            new ArrayList<>(Arrays.asList(1,4,2,3)),
            new ArrayList<>(Arrays.asList(2,5,1,6)))
    );
    System.out.println(
        new NMaxPairCombinations().solve(
            new ArrayList<>(Arrays.asList(3, 2, 4, 2)),
            new ArrayList<>(Arrays.asList(4, 3, 1, 2)))
    );
  }

  public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
    PriorityQueue<Integer> queue =
        new PriorityQueue<Integer>(Comparator.reverseOrder());
    Collections.sort(A);
    Collections.sort(B);
    for (int i=A.size()-1; i>=0; i--) {
      for (int j=B.size()-1; j>=0; j--) {
        if (queue.size() < A.size()) {
          queue.add(A.get(i) + B.get(j));
        } else {
          if (queue.peek() < A.get(i) + B.get(j)) {
            queue.add(A.get(i) + B.get(j));
            queue.poll();
          } else {
            break;
          }
        }
      }
    }

    ArrayList<Integer> ans = new ArrayList<>();
    for(int k=0; k<A.size();k++){
      ans.add(queue.poll());
    }
    Collections.sort(ans, Comparator.reverseOrder());
    return ans;
  }

}
