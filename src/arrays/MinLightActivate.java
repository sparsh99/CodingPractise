package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MinLightActivate {

  public static void main(String[] args) {

    System.out.println(new MinLightActivate().solve(
        new ArrayList<>(
            Arrays.asList(
                1, 1, 1, 1, 1, 0, 0
            )
        ),
        3
        ));
  }


  public int solve(ArrayList<Integer> A, int B) {
    // for each dark sub-array x to x+B there must exist a light within the range.
    // since we are iterating left to right, we choose the one with furthest light index to optimise.

    int minDone = 0; // tells where source of light is
    int maxDone = 0; // tells till where light is lit
    int currentLight = Math.min(B-1, A.size() - 1); // tells where current light is being evaluated
    int count = 0; // keeps count of no of lights lit
    while(maxDone < A.size() - 1) {

      while(A.get(currentLight) != 1) {
        if (minDone+1==currentLight) return -1;
        else currentLight--;
      }

      count++;
      minDone = currentLight;
      maxDone = Math.min(A.size() - 1, currentLight + B - 1);
      currentLight = Math.min(A.size() - 1, maxDone + B);
    }

    return count;
  }

}
