package heapsandmaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DistinctNosInWindow {

  public static void main(String[] args) {
    System.out.println(new DistinctNosInWindow().dNums(
        new ArrayList<>(Arrays.asList(1, 2, 1, 3, 4, 3)),
        3
    ));
    System.out.println(new DistinctNosInWindow().dNums(
        new ArrayList<>(Arrays.asList(1, 1, 2, 2)),
        1
    ));
  }

  public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
    Map<Integer, Integer> m = new HashMap<>();
    ArrayList<Integer> ans = new ArrayList<>();
    for (int i=0; i<A.size(); i++) {
      if (i < B-1) {
        m.put(A.get(i), m.getOrDefault(A.get(i), 0) + 1);
      } else if (i == B-1) {
        m.put(A.get(i), m.getOrDefault(A.get(i), 0) + 1);
        ans.add(m.keySet().size());
      } else {
        m.put(A.get(i-B), m.get(A.get(i-B)) - 1);
        if (m.get(A.get(i-B)) == 0) {
          m.remove(A.get(i-B));
        }

        m.put(A.get(i), m.getOrDefault(A.get(i), 0) + 1);
        ans.add(m.keySet().size());
      }
    }

    return ans;
  }
}
