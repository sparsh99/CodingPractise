package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class PairsWithGivenXor {

  public static void main(String[] args) {
    System.out.println(new PairsWithGivenXor().solve(
        new ArrayList<>(Arrays.asList(5, 4, 10, 15, 7, 6)),
        5
    ));
    System.out.println(new PairsWithGivenXor().solve(
        new ArrayList<>(Arrays.asList(3, 6, 8, 10, 15, 50)),
        5
    ));
  }

  public int solve(ArrayList<Integer> A, int B) {
    int cnt = 0;
    HashSet<Integer> C = new HashSet<>();
    for (Integer a: A) {
      if (C.contains(a ^ B)) {
        cnt ++;
      }
      C.add(a);
    }

    return cnt;
  }
}
