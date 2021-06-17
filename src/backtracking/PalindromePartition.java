package backtracking;

import java.util.ArrayList;

public class PalindromePartition {

  public static void main(String[] args) {
    System.out.println(new PalindromePartition().partition("aab"));
  }

  ArrayList<ArrayList<String>> ans;

  public ArrayList<ArrayList<String>> partition(String a) {
    ans = new ArrayList<ArrayList<String>>();
    partition(new ArrayList<>(),0, a);
    return ans;
  }

  public void partition(ArrayList<String> current, int index, String a) {
    if (index == a.length()) {
      ans.add(new ArrayList<>(current));
      return;
    }

    for (int i=index+1; i<=a.length(); i++) {
      String curr = a.substring(index, i);
      if (checkPalindrome(curr)) {
        current.add(curr);
        partition(current, i, a);
        current.remove(current.size()-1);
      }
    }
  }

  private boolean checkPalindrome(String a) {
    for (int i=0; i<a.length()/2; i++) {
      if (a.charAt(i) != a.charAt(a.length()-i-1)) {
        return false;
      }
    }
    return true;
  }

}
