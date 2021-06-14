package stackqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class RainWaterTrapped {

  public static void main(String[] args) {
    System.out.println(
        new RainWaterTrapped().trap(new ArrayList<>(Arrays.asList(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
    );
    System.out.println(
        new RainWaterTrapped().trap(new ArrayList<>(Arrays.asList(1, 2)))
    );
  }

  public int trap(final List<Integer> A) {
    ArrayList<Integer> maxHeightLeft = new ArrayList<>();
    int maxTillNow = 0;
    for (int i=0; i<A.size(); i++) {
      if (A.get(i) > maxTillNow) {
        maxHeightLeft.add(-1);
        maxTillNow = A.get(i);
      } else {
        maxHeightLeft.add(maxTillNow);
      }
    }

    int ans = 0;
    maxTillNow = 0;
    for (int i=A.size()-1; i>=0; i--) {
      if (A.get(i) > maxTillNow) {
        maxTillNow = A.get(i);
      } else if (maxHeightLeft.get(i) != -1) {
        ans += Math.min(maxTillNow, maxHeightLeft.get(i)) - A.get(i);
      }
    }

    return ans;
  }

  public int trap1(final List<Integer> A) {
    Stack<Integer> s = new Stack<>();
    ArrayList<Integer> maxHeightLeft = new ArrayList<>();
    for(int i=0; i<A.size(); i++) {
      while(!s.isEmpty() && A.get(s.peek()) < A.get(i)) {
        s.pop();
      }

      if (s.isEmpty()) {
        maxHeightLeft.add(-1);
        s.push(i);
      } else {
        maxHeightLeft.add(s.peek());
      }
    }

    s.clear();
    int ans = 0;
    for (int i=A.size()-1; i>=0; i--) {
      while (!s.isEmpty() && A.get(s.peek()) < A.get(i)) {
        s.pop();
      }

      if (!s.isEmpty() && maxHeightLeft.get(i) > 0) {
        ans += Math.min(A.get(maxHeightLeft.get(i)), s.peek()) - A.get(i);
      }

      if (s.isEmpty()) {
        s.push(i);
      }
    }

    return ans;
  }

}
