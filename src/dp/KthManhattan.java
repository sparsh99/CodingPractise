package dp;

public class KthManhattan {

  public static void main(String[] args) {
    print2dArr(
        new KthManhattan().solve(2, new int[][]{new int[] {1,2,4}, new int[] {4,5,8}})
    );
    print2dArr(
        new KthManhattan().solve(2, new int[][]{new int[] {4,2,3}, new int[] {8,10,8}})
    );
  }

  private static void print2dArr(int[][] B) {
    for (int i=0; i<B.length; i++) {
      for (int j=0; j<B[0].length; j++) {
        System.out.print(B[i][j] + " ");
      }
      System.out.println();
    }
  }

  public int[][] solve(int A, int[][] B) {
    int[][] prevDp = new int[B.length][B[0].length];
    int[][] dp = null;

    for (int k=0; k<=A; k++) {
      dp = new int[B.length][B[0].length];
      for (int i=0; i<B.length; i++) {
        for (int j=0; j<B[0].length; j++) {
          dp[i][j] = B[i][j];
          if (i>0 && dp[i][j] < prevDp[i-1][j])
            dp[i][j] = prevDp[i-1][j];
          if (i<B.length-1 && dp[i][j] < prevDp[i+1][j])
            dp[i][j] = prevDp[i+1][j];
          if (j>0 && dp[i][j] < prevDp[i][j-1])
            dp[i][j] = prevDp[i][j-1];
          if (j<B[0].length-1 && dp[i][j] < prevDp[i][j+1])
            dp[i][j] = prevDp[i][j+1];
        }
      }
      prevDp = dp;
    }

    return prevDp;
  }
}
