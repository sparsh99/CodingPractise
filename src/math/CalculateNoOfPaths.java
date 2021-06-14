package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class CalculateNoOfPaths {

  int total = 0;
  int MODULUS = 1000000007;

  public static void main(String[] args) {
    System.out.println(new CalculateNoOfPaths().solve(48, new ArrayList<>(Arrays.asList(5, 12, 48, 34, 21, 29, 25, 11, 37, 26, 14, 15, 35, 41, 24, 39, 10, 17, 23, 16, 8, 44, 13, 31))));
  }

  public int solve(int A, ArrayList<Integer> B) {
    total = A;
    //If a city with index i is visited, you can visit either the city with index i-1 (i >= 2)
    // or the city with index i+1 (i < A) if they are not already visited.
    long cnt = 0;
    for (int i=1; i<=A; i++) {
      if (!B.contains(i) && (B.contains(i-1) || B.contains(i+1))) {
        B.add(i);
        cnt = (cnt + noOfWays(B)) % MODULUS;
        B.removeAll(Arrays.asList(i));
      }
    }
    return (int) cnt;
  }

  private int noOfWays(ArrayList<Integer> visited) {
    if (visited.size() == total) {
      System.out.println(Arrays.toString(visited.toArray(new Integer[0])));
      return 1;
    }

    long cnt = 0;
    for (int i=1; i<=total; i++) {
      if (!visited.contains(i) && (visited.contains(i-1) || visited.contains(i+1))) {
        visited.add(i);
        cnt = (cnt + noOfWays(visited)) % MODULUS;
        visited.removeAll(Arrays.asList(i));
      }
    }

//    for (int i=0; i<visited.size(); i++) {
//      if (visited.get(i) > 1 && !visited.contains(visited.get(i) - 1)) {
//        visited.add(visited.get(i) - 1);
//        cnt = (cnt + noOfWays(visited)) % MODULUS;
//        visited.removeAll(Arrays.asList(visited.get(i) - 1));
//      }
//
//      if (visited.get(i) + 1 < total && !visited.contains(visited.get(i) + 1)) {
//        visited.add(visited.get(i) + 1);
//        cnt = (cnt + noOfWays(visited)) % MODULUS;
//        visited.removeAll(Arrays.asList(visited.get(i) + 1));
//      }
//    }

    return (int) cnt;
  }
}
