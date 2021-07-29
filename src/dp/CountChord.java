package dp;

public class CountChord {

  public static void main(String[] args) {
//    System.out.println(new CountChord().chordCnt(0));
//    System.out.println(new CountChord().chordCnt(1));
//    System.out.println(new CountChord().chordCnt(2));
    System.out.println(new CountChord().chordCnt(3));
//    System.out.println(new CountChord().chordCnt(4));
  }

  public int chordCnt(int A) {
    if (A==0) return 0;
    long MOD = 1000000007;
    long[] dp = new long[A+1];
    for (int i=0; i<=A; i++) { // i shows total number of nodes
      if (i==0) dp[i] = 1;
      for (int j=0; j<i; j++) { // j shows number of nodes on left, i-j-1 nodes on right
        dp[i] = (dp[i] + (dp[j]*dp[i-1-j]))%MOD;
      }
    }

    return (int)dp[A];
  }
}
