package dp;

public class ClimbStairs {

  public static void main(String[] args) {
    System.out.println(new ClimbStairs().climbStairs(1));
    System.out.println(new ClimbStairs().climbStairs(5));
  }

  public int climbStairs(int A) {
    int prev_1 = 1, prev = 2;

    if (A == 1) {
      return prev_1;
    }

    for (int i=2; i<A; i++) {
      int curr = prev_1 + prev;
      prev_1 = prev;
      prev = curr;
    }

    return prev;
  }
}
