package dp;

public class LengthOfLongIncAndDecSequence {

  public static void main(String[] args) {
    System.out.println(
        new LengthOfLongIncAndDecSequence().longestSubsequenceLength(1, 2, 1)
    );
    System.out.println(
        new LengthOfLongIncAndDecSequence().longestSubsequenceLength(1, 11, 2, 10, 4, 5, 2, 1)
    );
  }

  public int longestSubsequenceLength(final int ...A) {
    int[] maxInc = new int[A.length];
    int[] maxDec = new int[A.length];

    for (int i=0; i<A.length; i++) {
      for (int k=0; k<i; k++) {
        if (A[k] < A[i] && maxInc[i] < maxInc[k] + 1)
          maxInc[i] = maxInc[k] + 1;
      }
    }

    int ans =0 ;
    for (int i=A.length-1; i>=0; i--) {
      for (int k=i+1; k<A.length; k++) {
        if (A[k] < A[i] && maxDec[i] < maxDec[k] + 1)
          maxDec[i] = maxDec[k] + 1;
      }

      if (ans < maxDec[i] + maxInc[i] + 1) {
        ans = maxDec[i] + maxInc[i] + 1;
      }
    }

    return ans;
  }
}
