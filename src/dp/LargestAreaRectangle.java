package dp;

public class LargestAreaRectangle {

  public static void main(String[] args) {
    int[][] A = {
        {1, 0, 1},
        {0, 1 ,0},
        {1, 0, 0},
    };
    System.out.println(
        new LargestAreaRectangle().solve(A)
    );
  }

  public int solve(int[][] A) {
    int[][] dpRow = new int[A.length][A[0].length];
    int[][] dpCol = new int[A.length][A[0].length];
    int maxRect = 0;
    for (int i=0; i<A[0].length; i++) {
      int oneRowCnt = 0;
      for (int j=0; j<=i; j++) {
        for (int k=0; k<A.length; k++) {
          if (A[k][i] == 1) {
            oneRowCnt++;
            dpRow[k][i] = 1;
            dpRow[k][i] = Math.min(dpRow[j][i], oneRowCnt);
            dpCol[k][i] = dpCol[j][i] + 1;
          } else {
            oneRowCnt = 0;
          }

          if (maxRect < dpRow[k][i] * dpCol[k][i]) {
            maxRect = dpRow[k][i] * dpCol[k][i];
          }
        }
      }
    }

    return maxRect;
  }

  public int solveNoColMovement(int[][] A) {
    int[][] dpRow = new int[A.length][A[0].length];
    int[][] dpCol = new int[A.length][A[0].length];
    int maxRect = 0;
    for (int i=0; i<A.length; i++) {
      for (int j=0; j<A[0].length; j++) {
        if (A[i][j] == 0) continue;

        if (i==0 && j == 0) {
          dpRow[i][j] = 1;
          dpCol[i][j] = 1;
        } else if (i == 0) {
          dpRow[i][j] = dpRow[i][j-1] + 1;
          dpCol[i][j] = dpCol[i][j-1] + 1;
        } else if (j == 0) {
          dpRow[i][j] = dpRow[i-1][j] + 1;
          dpCol[i][j] = dpCol[i-1][j] + 1;
        } else {
          dpRow[i][j] = Math.min(dpRow[i-1][j-1], dpRow[i-1][j]) + 1;
          dpCol[i][j] = Math.min(dpCol[i-1][j-1], dpCol[i][j-1]) + 1;
        }

        if (maxRect < dpRow[i][j]*dpCol[i][j]) {
          maxRect = dpRow[i][j]*dpCol[i][j];
        }
      }
    }

    return maxRect;
  }
}
