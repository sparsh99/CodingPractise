package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class SubstringConcatenation {

  public static void main(String[] args) {
//    System.out.println(
//        new SubstringConcatenation()
//            .findSubstring("barfoothefoobarman", Arrays.asList("foo", "bar"))
//    );

    System.out.println(
        new SubstringConcatenation()
            .findSubstring("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                Arrays.asList("aaa", "aaa", "aaa", "aaa", "aaa" ))
    );
  }

  // DO NOT MODIFY THE LIST. IT IS READ ONLY
  public ArrayList<Integer> findSubstring(String A, final List<String> B) {
    int strLen = B.get(0).length();
    int totStrLen = B.get(0).length() * B.size();

    Map<String, Integer> BCntMap = new HashMap<>();
    for (String b: B) {
      if (BCntMap.containsKey(b)) {
        BCntMap.put(b, BCntMap.get(b) + 1);
      } else {
        BCntMap.put(b, 1);
      }
    }

    ArrayList<Integer> ans = new ArrayList<>();
    for (int i=0; i<=A.length()-totStrLen; i++) {
      HashMap<String, Integer> cntMap = new HashMap<>();
      for (int j=0; j<B.size(); j++) {
        String subStr = A.substring(i + j*strLen, i + j*strLen + strLen);
        if (!B.contains(subStr)) {
          break;
        }

        if (cntMap.containsKey(subStr)) {
          cntMap.put(subStr, cntMap.get(subStr) + 1);
        } else {
          cntMap.put(subStr, 1);
        }

        if (BCntMap.get(subStr) < cntMap.get(subStr)) {
          break;
        }
      }

      boolean isValidAns = true;
      for (String b: B) {
        if (!cntMap.containsKey(b) || !cntMap.get(b).equals(BCntMap.get(b))) {
          isValidAns = false;
          break;
        }
      }

      if (isValidAns) {
        ans.add(i);
      }
    }

    return ans;
  }


}
