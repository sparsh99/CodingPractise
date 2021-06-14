package string;

public class ReverseTheString {

  public static void main(String[] args) {
//    System.out.println(new ReverseTheString()
//        .solve("fwbpudnbrozzifml osdt ulc jsx kxorifrhubk ouhsuhf sswz qfho dqmy sn myq igjgip iwfcqq"));
    System.out.println(new ReverseTheString()
        .solve("x tb i f chfpzf"));
  }

  public String solve(String A) {
    int i=1;
    int prev=0;
    String ans = "";
    while(i<A.length()) {
      if (A.charAt(i) == ' ' && A.charAt(i-1) != ' ') {
        String word = A.substring(prev, i);
        ans = (ans.length() >= 1) ? word + " " + ans : word;
      } else if (A.charAt(i) != ' ' && A.charAt(i-1) == ' ') {
        prev = i;
      } else if (A.charAt(i) == ' ') {
        prev = -1;
      }
      i++;
    }

    if (prev != -1 || prev == i) {
      String word = A.substring(prev, i);
      ans = (ans.length() > 1) ? word + " " + ans : word;
    }

    return ans;
  }
}
