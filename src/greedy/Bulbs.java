package greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class Bulbs {

  public static void main(String[] args) {
    System.out.println(new Bulbs().bulbs(new ArrayList<>(Arrays.asList(1))));
    System.out.println(new Bulbs().bulbs(new ArrayList<>(Arrays.asList(0, 1, 0, 1))));
  }

  public int bulbs(ArrayList<Integer> A) {
    boolean inverted = false;
    int cnt = 0;
    for (int i=0; i<A.size(); i++) {
      if (!inverted && A.get(i) == 0) {
        cnt++;
        inverted = !inverted;
      } else if (inverted && A.get(i) == 1) {
        cnt++;
        inverted = !inverted;
      }
    }

    return cnt;
  }
}
