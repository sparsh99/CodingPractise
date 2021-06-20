package hashing;

import java.util.HashMap;

public class CheckPalindrome {

  public static void main(String[] args) {
    System.out.println(new CheckPalindrome().solve("abcde"));
    System.out.println(new CheckPalindrome().solve("abbaee"));
  }

  public int solve(String A) {
    HashMap<Character, Integer> cntMap = new HashMap<>();
    for (int i=0; i<A.length(); i++) {
      cntMap.put(A.charAt(i), cntMap.getOrDefault(A.charAt(i), 0) + 1);
    }

    boolean oddAlreadyFound = false;
    for (Character c: cntMap.keySet()) {
      if (cntMap.get(c) % 2 == 1) {
        if (oddAlreadyFound) return 0;
        else oddAlreadyFound = true;
      }
    }

    return 1;
  }
}
