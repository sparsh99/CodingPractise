package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class WaysToColor3nBoard {

  public static void main(String[] args) {
    System.out.println(new WaysToColor3nBoard().solve(2));
    System.out.println(new WaysToColor3nBoard().solve(100000));
  }

  public int solveImp(int A) {

    long color3 = 24; // When we to fill single column
    long color2 = 12;
    long temp = 0;
    for (int i = 2; i <= A; i++)
    {
      temp = color3;
      color3 = (11 * color3 + 10 * color2 ) % 1000000007;
      color2 = ( 5 * temp + 7 * color2 ) % 1000000007;
    }
    long num = (color3 + color2) % 1000000007;
    return (int)num;
  }

  public int solve(int A) {
    int MOD = 1000000007;
    HashMap<Integer, Integer> prevDp = new HashMap<>();
    HashMap<Integer, Integer> dp = new HashMap<>();
    for (int i=0; i<A; i++) {
      dp = new HashMap<>();

      for (int j=1; j<=4; j++) {
        for (int k=1; k<=4; k++) {
          for (int l=1; l<=4; l++) {

            if (isValidKey(j, k, l)) {
              int key = createKey(j, k, l);
              if (i==0) {
                dp.put(key, 1);
                continue;
              }

              for (int key2 : prevDp.keySet()) {
                if (isValidKeyComb(key, key2)) {
                  dp.put(
                      key,
                      (dp.getOrDefault(key, 0)
                          + prevDp.get(key2))%MOD
                  );
                }
              }
            }

          }
        }
      }

      prevDp = dp;
    }

    int ans = 0;
    for (int key : dp.keySet()) {
      ans = (ans + dp.get(key))%MOD;
    }

    return ans;
  }

  public boolean isValidKey(int a, int b, int c) {
    return (a != b && b != c);
  }

  public Integer createKey(int a, int b, int c) {
    return a*100 + b*10 + c;
  }

  public boolean isValidKeyComb(int key1, int key2) {
    int a1 = key1/100;
    int b1 = key1/10 - a1*10;
    int c1 = key1%10;
    int a2 = key2/100;
    int b2 = key2/10 - a2*10;
    int c2 = key2%10;

    if (a1 == a2 || b1 == b2 || c1 == c2) {
      return false;
    }
    return true;
  }
}
