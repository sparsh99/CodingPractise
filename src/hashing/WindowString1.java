package hashing;

import java.util.HashMap;
import java.util.Map;

public class WindowString1 {

  public static void main(String[] args) {
    System.out.println(new WindowString1().minWindow("AXBCA", "ABC"));
//    System.out.println(new WindowString1().minWindow("", ""));
  }

  public String minWindow(String A, String B) {
    Map<Character, Integer> bCntMapOrig = new HashMap<>();
    for (Character c: B.toCharArray()) {
      bCntMapOrig.put(c, bCntMapOrig.getOrDefault(c, 0) + 1);
    }

    // we find first valid window
    Map<Character, Integer> tempBCnt = new HashMap<>(bCntMapOrig); // temp array to find first
    Map<Character, Integer> bCntInA = new HashMap<>(); // keeps count of b matching characters in a
    int firstS = -1;
    int firstE = -1;
    for (int i=0; i<A.length(); i++) {
      Character a = A.charAt(i);

      if (bCntMapOrig.containsKey(a)) {
        bCntInA.put(a, bCntInA.getOrDefault(a, 0) + 1);
      }

      if (tempBCnt.containsKey(a)) {
        tempBCnt.put(a, tempBCnt.get(a) - 1);
        if (tempBCnt.get(a) == 0) tempBCnt.remove(a);
      }

      if (firstS == -1 && bCntMapOrig.containsKey(a)) {
        firstS = i;
      }

      if (tempBCnt.size() == 0) { // we have found all elements with required or more counts
        firstE = i;
        break;
      }
    }

    if (firstE == -1) { // we did not find all characters
      return "";
    }

    int currS = firstS;
    int currE = firstE;
    int alen = A.length();
    int ansS = firstS;
    int ansE = firstE;
    while (currS < alen) {
      // we move s one step and if we loose any character
      // then we move currE till we find the same character
      Character a = A.charAt(currS);
      currS++;

      if (bCntMapOrig.containsKey(a)) {
        bCntInA.put(a, bCntInA.get(a) - 1);

        if (bCntInA.get(a) < bCntMapOrig.get(a)) { // some character count reduced below required, we iterate end to find it.
          currE++;
          while(currE < alen) {
            Character eA = A.charAt(currE);
            if (bCntInA.containsKey(eA)) {
              bCntInA.put(eA, bCntInA.get(eA) + 1);
            }

            if (A.charAt(currE) == a) {
              break;
            }
            currE++;
          }

          if (currE == alen) break; // we did not find the lost char
        }
      }

      if ((currE - currS) < (ansE - ansS)) {
        ansE = currE;
        ansS = currS;
      }
    }

    return A.substring(ansS, ansE+1);
  }
}
