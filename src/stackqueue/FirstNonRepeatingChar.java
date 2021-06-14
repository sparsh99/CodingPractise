package stackqueue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstNonRepeatingChar {

  public static void main(String[] args) {
    System.out.println(
        new FirstNonRepeatingChar().solve("xxikrwmjvsvckfrqxnibkcasompsuyuogauacjrr"));
    System.out.println(
        new FirstNonRepeatingChar().solve("abadbc"));
    System.out.println(
        new FirstNonRepeatingChar().solve("abcabc"));
  }

  public String solve(String A) {
    Queue<Character> q = new LinkedList<Character>();
    Map<Character, Integer> cntMap = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<A.length(); i++) {
      q.add(A.charAt(i));

      if (cntMap.containsKey(A.charAt(i))) {
        cntMap.put(A.charAt(i), cntMap.get(A.charAt(i)) + 1);
      } else {
        cntMap.put(A.charAt(i), 1);
      }

      while (q.size() > 0 && cntMap.get(q.peek()) > 1) {
        q.poll();
      }

      if (q.size() > 0) {
        sb.append(q.peek());
      } else {
        sb.append("#");
      }

    }

    return sb.toString();
  }
}
