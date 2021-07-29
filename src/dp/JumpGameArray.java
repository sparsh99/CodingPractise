package dp;

import java.util.ArrayList;
import java.util.Arrays;

public class JumpGameArray {

  public static void main(String[] args) {
    System.out.println(new JumpGameArray().canJump(new ArrayList<>(Arrays.asList(2,3,1,1,4))));
    System.out.println(new JumpGameArray().canJump(new ArrayList<>(Arrays.asList(3,2,1,0,4))));
  }

  public int canJump(ArrayList<Integer> A) {
    int currMaxIndex = 0;
    for (int i=0; i<A.size(); i++) {
      if (i > currMaxIndex) return 0; // i cannot be reached
      if (A.get(i) + i > currMaxIndex) currMaxIndex = i+A.get(i);
    }

    return 1;
  }
}
