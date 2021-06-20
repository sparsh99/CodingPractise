package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckAnagram {

  public static void main(String[] args) {
    System.out.println(
        new CheckAnagram().anagrams(Arrays.asList("cat", "dog", "god", "tca"))
    );
  }

  public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
    Map<String, ArrayList<Integer>> ans = new HashMap<>();
    for (int i=0; i<A.size(); i++) {
      char[] charArr = A.get(i).toCharArray();
      Arrays.sort(charArr);
      String key = new String(charArr);
      if (!ans.containsKey(key)) {
        ans.put(key, new ArrayList<>());
      }
      ans.get(key).add(i+1);
    }
    return new ArrayList<>(ans.values());
  }

}
