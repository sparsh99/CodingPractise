package heapsandmaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MagicianAndChocolates {

  public static void main(String[] args) {
    System.out.println(new MagicianAndChocolates().nchoc(3, new ArrayList<>(Arrays.asList(6,5))));
    System.out.println(new MagicianAndChocolates().nchoc(5, new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10))));
  }

  public int nchoc(int A, ArrayList<Integer> B) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i=0; i<B.size(); i++) {
      pq.add(B.get(i));
    }

    long ans = 0;
    for (int i=0; i<A; i++) {
      int s = pq.poll();
      ans = (ans + s)%1000000007;
      pq.add(s/2);
    }

    return (int) ans;
  }
}
