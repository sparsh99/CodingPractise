package stackqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NearestSmallestNumber {

  public static void main(String[] args) {
    System.out.println(new NearestSmallestNumber().prevSmaller(new ArrayList<>(
        Arrays.asList(
            4, 5, 2, 10, 8
        )
    )));
  }

  public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
    Stack<Integer> s = new Stack<>();
    ArrayList<Integer> ans = new ArrayList<>();
    for(int i=0; i<A.size(); i++) {
      while(!s.isEmpty() && s.peek() >= A.get(i)) {
        s.pop();
      }
      if (s.isEmpty()) {
        ans.add(-1);
      } else {
        ans.add(s.peek());
      }

      s.push(A.get(i));
    }

    return ans;
  }
}
