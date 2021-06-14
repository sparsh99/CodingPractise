package stackqueue;

import java.util.Stack;

public class DesignMinStack {

  Stack<Integer> s = new Stack<>();
  Stack<Integer> minS = new Stack<>();

  public void push(int x) {
    s.push(x);
    if (minS.isEmpty() || minS.peek() >= x) {
      minS.push(x);
    }
  }

  public void pop() {
    if (!s.isEmpty()) {
      int x = s.pop();
      if (minS.peek() == x) {
        minS.pop();
      }
    }
  }

  public int top() {
    return (s.isEmpty()) ? -1 : s.peek();
  }

  public int getMin() {
    return (minS.isEmpty()) ? -1 : minS.peek();
  }
}
