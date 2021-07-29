package dp;

import java.util.ArrayList;
import java.util.Arrays;

public class MinJumpCount {

  public static void main(String[] args) {
    System.out.println(new MinJumpCount().jump(new ArrayList<>(Arrays.asList(2, 1, 1))));
    System.out.println(new MinJumpCount().jump(new ArrayList<>(Arrays.asList(2,3,1,1,4))));
  }

  public int jump(ArrayList<Integer> A) {
    int jumpCnt = 0;
    int i=0;
    while (i < A.size()) {
      if (A.get(i) > 0) jumpCnt++;

      if (i + A.get(i) >= A.size()-1) {
        return jumpCnt;
      }

      int maxJumpIndex = -1;
      int maxJump = -1;
      for (int j=i+1; j<=(i+A.get(i)); j++) {
        if (A.get(j) + j > maxJump) {
          maxJump = A.get(j) + j;
          maxJumpIndex = j;
        }
      }

      if (maxJumpIndex <= 0) return -1;
      i = maxJumpIndex;
    }

    return -1;
  }
}
