package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IncrementStream {

  public static void main(String[] args) {
    System.out.println(new IncrementStream().solve(
        new ArrayList<>(Arrays.asList(
            1, 1
        ))
    ));

    System.out.println(new IncrementStream().solve(
        new ArrayList<>(Arrays.asList(
            1, 2, 3, 2, 3, 1, 4, 2, 1, 3
        ))
    ));
  }

  public ArrayList<Integer> solve(ArrayList<Integer> A) {
    Map<Integer, List<Integer>> firstOcc = new HashMap<>();
    for (int i=0; i<A.size(); i++) {
      if (firstOcc.containsKey(A.get(i)) && !firstOcc.get(A.get(i)).isEmpty()) {
        // get first index
        int firstIndex = firstOcc.get(A.get(i)).get(0);

        // remove first index
        firstOcc.get(A.get(i)).remove(0);

        // move first index to A.get(i) + 1
        if (!firstOcc.containsKey(A.get(i) + 1)) {
          firstOcc.put(A.get(i) + 1, new ArrayList<>());
        }

        A.set(firstIndex, A.get(i) + 1);
        firstOcc.get(A.get(i) + 1).add(firstIndex);
        Collections.sort(firstOcc.get(A.get(i) + 1));
      }

      if (!firstOcc.containsKey(A.get(i))) {
        firstOcc.put(A.get(i), new ArrayList<>());
      }

      firstOcc.get(A.get(i)).add(i);
    }

    return A;
  }

}
