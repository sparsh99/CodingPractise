package stackqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ParenthesisMatch {

  public static void main(String[] args) {
    System.out.println(new ParenthesisMatch().isValid("()[]{}"));
    System.out.println(new ParenthesisMatch().isValid(")}"));
  }

  public int isValid(String A) {
    Stack<Character> stack = new Stack<Character>();
    Map<Character, Character> charPair = new HashMap<>();
    charPair.put('}', '{');
    charPair.put(']', '[');
    charPair.put(')', '(');
    for(int i=0; i<A.length(); i++) {
      Character a = A.charAt(i);
      if (charPair.containsKey(a)) {
        if (stack.size() == 0 || stack.peek() != charPair.get(a)) {
          return 0;
        } else {
          stack.pop();
        }
      } else {
        stack.push(a);
      }
    }

    if (stack.size() > 0) {
      return 0;
    }

    return 1;
  }
}
