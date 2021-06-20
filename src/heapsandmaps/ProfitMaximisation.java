package heapsandmaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ProfitMaximisation {

  public static void main(String[] args) {
    System.out.println(new ProfitMaximisation().solve(new ArrayList<>(Arrays.asList(2, 3)), 3));
    System.out.println(new ProfitMaximisation().solve(new ArrayList<>(Arrays.asList(1, 4)), 2));
  }

  public int solve(ArrayList<Integer> A, int B) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i=0; i<A.size(); i++) {
      pq.add(A.get(i));
    }

    int ans = 0;
    for (int i=0; i<B; i++) {
      int s = pq.poll();
      ans += s;
      pq.add(s-1);
    }

    return ans;
  }
}
