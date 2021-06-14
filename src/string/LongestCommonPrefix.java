package string;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestCommonPrefix {

  public static void main(String[] args) {
    System.out.println(
        new LongestCommonPrefix().longestCommonPrefix(new ArrayList<>(Arrays.asList(
            "abcdefgh", "aefghijk", "abcefgh"
        )))
    );
  }

  public String longestCommonPrefix(ArrayList<String> A) {
    String prefix = A.get(0);
    for (int i=0; i<A.size(); i++) {
      int j=0;
      while(j<prefix.length() && j<A.get(i).length()
          && A.get(i).substring(0, j+1).equals(A.get(i))) {
        j++;
      }
      prefix = prefix.substring(0, j);
    }

    return prefix;
  }
}
