package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HighestProduct {

  public static void main(String[] args) {
    System.out.println(new HighestProduct().maxp3(new ArrayList<>(Arrays.asList(1, 2, 3, 4))));
    System.out.println(new HighestProduct().maxp3(new ArrayList<>(Arrays.asList(0, -1, 3, 100, 70, 50))));
  }

  public int maxp3(ArrayList<Integer> A) {
    Collections.sort(A);
    return Math.max(
        A.get(0) * A.get(1) * A.get(A.size()-1),
        A.get(A.size()-3) * A.get(A.size()-2) * A.get(A.size()-1)
    );
  }
}
