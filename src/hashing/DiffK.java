package hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class DiffK {

  public static void main(String[] args) {
    System.out.println(new DiffK().diffPossible(Arrays.asList(1, 5,3), 2));
  }

  public int diffPossible(final List<Integer> A, int B) {
    HashSet<Integer> m = new HashSet<>();
    for (int i=0; i<A.size(); i++) {
      if (m.contains(A.get(i) - B)) {
        return 1;
      }

      if (m.contains(A.get(i) + B)) {
        return 1;
      }

      m.add(A.get(i));
    }

    return 0;
  }
}
