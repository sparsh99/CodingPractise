package math;

public class FibonnaciUsingMatrixMulti {
  /*
    Solves in log n time.
    (Fn+1 Fn   )   = (1 1)^n
    ( Fn  Fn-1 )     (1 0)
   */
  public void multiply(long F[][], long M[][])  {
    long x =  F[0][0]% 1000000007*M[0][0]% 1000000007 + F[0][1]% 1000000007*M[1][0]% 1000000007;
    long y =  F[0][0]% 1000000007*M[0][1]% 1000000007 + F[0][1]% 1000000007*M[1][1]% 1000000007;
    long z =  F[1][0]% 1000000007*M[0][0]% 1000000007 + F[1][1]% 1000000007*M[1][0]% 1000000007;
    long w =  F[1][0]% 1000000007*M[0][1]% 1000000007 + F[1][1]% 1000000007*M[1][1]% 1000000007;
    F[0][0] = x;
    F[0][1] = y;
    F[1][0] = z;
    F[1][1] = w;
  }

  public void power(long [][]ans , int n) {
    if(n == 1 || n == 1)
      return ;
    long [][]temp = new long[][]{{1,1},{1,0}};
    power(ans, n / 2);
    multiply(ans, ans);
    if(n % 2 == 1)
      multiply(ans, temp);
  }

  public int solve(int n) {
    long ans[][] = new long[][]{{1,1},{1,0}};
    if(n == 0)
      return 0;
    power(ans, n - 1);
    return (int)(ans[0][0] % 1000000007);
  }
}
