package stackqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class EvaluateExpression {

  public static void main(String[] args) {
    System.out.println(
        new EvaluateExpression().evalRPN(new ArrayList<>(Arrays.asList("2", "1", "+", "3", "*")))
    );
    System.out.println(
        new EvaluateExpression().evalRPN(new ArrayList<>(Arrays.asList("4", "13", "5", "/", "+")))
    );
  }

  public int evalRPN(ArrayList<String> A) {
    Stack<String> s = new Stack<>();
    List<String> operations = Arrays.asList("+", "-", "*", "/");
    for (int i=0; i<A.size(); i++) {
      if (operations.contains(A.get(i))) {
        Integer o1 = Integer.valueOf(s.pop());
        Integer o2 = Integer.valueOf(s.pop());
        Integer r1 =
            (A.get(i).equals("+")) ? o1 + o2
                : ((A.get(i).equals("-")) ? o2 - o1
                    : (A.get(i).equals("*") ? o2 * o1 : o2/o1));
        s.push(String.valueOf(r1));
      } else {
        s.push(A.get(i));
      }
    }

    return Integer.valueOf(s.pop());
  }

}
