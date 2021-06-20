package heapsandmaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElements {

  public static void main(String[] args) {
    System.out.println(
        new KthLargestElements().solve(new ArrayList<>(Arrays.asList(11, 3, 4)), 2)
    );
  }

  public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i=0; i<A.size(); i++) {
      pq.add(A.get(i));
    }

    ArrayList<Integer> ans = new ArrayList<>();
    for (int i=0; i<B; i++) {
      ans.add(pq.poll());
    }

    return ans;
  }

}
