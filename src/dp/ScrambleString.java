package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ScrambleString {

  public static void main(String[] args) {
    System.out.println(new ScrambleString().isScramble("knxhpkpcogzwrwdyfksw", "fpsprgdywowkckhzxnkw"));
    System.out.println(new ScrambleString().isScrambleDP("knxhpkpcogzwrwdyfksw", "fpsprgdywowkckhzxnkw"));
    System.out.println(new ScrambleString().isScramble("abc", "abc"));
    System.out.println(new ScrambleString().isScrambleDP("abc", "abc"));
  }

  public int isScramble(final String A, final String B) {
    return isScrambleRecu(A, B) ? 1 : 0;
  }

  public boolean isScrambleRecu(String A, String B) {
    if (A.equals(B)) return true;
    else if (A.length() != B.length()) return false;

    char[] AChar = A.toCharArray();
    char[] BChar = B.toCharArray();
    Arrays.sort(AChar);
    Arrays.sort(BChar);
    if (!new String(AChar).equals(new String(BChar))) {
      return false;
    }

    for (int i=1; i<A.length(); i++) {
      if (isScrambleRecu(A.substring(0, i), B.substring(0, i))
          && isScrambleRecu(A.substring(i, A.length()), B.substring(i, A.length()))
      ) {
        return true;
      }

      if (isScrambleRecu(A.substring(0, i), B.substring(A.length()-i, A.length()))
          && isScrambleRecu(A.substring(i,A.length()), B.substring(0, A.length()-i))
      ) {
        return true;
      }
    }

    return false;
  }

  public int isScrambleDP(final String A, final String B) {
    Map<String, Set<String>> aToScramblesTrue = new HashMap<>();
    Map<String, Set<String>> aToScramblesFalse = new HashMap<>();
    return (isScrambleDPRecu(A, B, aToScramblesTrue, aToScramblesFalse)) ? 1 : 0;
  }

  public boolean isScrambleDPRecu(String A, String B, Map<String,
      Set<String>> t, Map<String, Set<String>> f) {
    if (A.length() != B.length()) return false;
    if (A.equals(B)) return true;
    if (A.length() == 1) return false;
    if (A.length() == 2) {
      return A.charAt(0) == B.charAt(1) && A.charAt(1) == B.charAt(0);
    }

    if (t.containsKey(A) && t.get(A).contains(B)) return true;
    if (f.containsKey(A) && f.get(A).contains(B)) return false;

    for (int i=1; i<A.length(); i++) {
      boolean isScrambled =
          (isScrambleDPRecu(A.substring(0, i), B.substring(0, i), t, f)
              && isScrambleDPRecu(A.substring(i, A.length()), B.substring(i, A.length()), t, f))
              || (isScrambleDPRecu(A.substring(0, i), B.substring(A.length()-i, A.length()), t, f)
              && isScrambleDPRecu(A.substring(i, A.length()), B.substring(0, A.length()-i), t, f));

      if (isScrambled) {
        if (!t.containsKey(A))
          t.put(A, new HashSet<>());
        t.get(A).add(B);
        return true;
      } else {
        if (!f.containsKey(A))
          f.put(A, new HashSet<>());
        f.get(A).add(B);
      }
    }

    return false;
  }
}
