package string;

public class LongestPalindromeSubstring {

  public static void main(String[] args) {
    System.out.println(
        new LongestPalindromeSubstring().longestPalindrome("A12421FAFAFF")
    );
  }
// TODO: This takes O(n^2) space, it is possible to do it
//  public String longestPalindrome(String A) {
//    boolean[][] dp = new boolean[A.length()][A.length()];
//    String maxPalindrome = "";
//    for (int i=0; i<A.length(); i++) {
//      for (int j=0; j<A.length()-i; j++) {
//        if (i==0) {
//          dp[j][j+i] = true;
//        } else if (i==1) {
//          dp[j][j+i] = (A.charAt(j) == A.charAt(j+i));
//        } else {
//          dp[j][j+i] = dp[j+1][j+i-1] && A.charAt(j) == A.charAt(j+i);
//        }
//
//        if (dp[j][j+i] && (i+1) > maxPalindrome.length()) {
//          maxPalindrome = A.substring(j, j+i+1);
//        }
//      }
//    }
//
//    return maxPalindrome;
//  }

  private int start, end, maxLength;

  // finds the longest palindrome with [left, right] as center
  private void checkPalindrome(String A, int left, int right) {
    while (left >= 0 && right < A.length() && A.charAt(left) == A.charAt(right)) {
      if (right - left + 1 > maxLength) {
        start = left;
        end = right + 1;
        maxLength = right - left + 1;
      }
      left--;
      right++;
    }
  }

  public String longestPalindrome(String A) {
    start = 0; end = 0; maxLength = 0;
    for (int i = 0; i < A.length(); i++) {
      checkPalindrome(A, i, i); // odd length, center in i
      checkPalindrome(A, i, i + 1); // even length, center between i and i + 1
    }
    return A.substring(start, end);
  }

}
