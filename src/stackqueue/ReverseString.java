package stackqueue;

import java.util.Stack;

public class ReverseString {

  public static void main(String[] args) {
    System.out.println(new ReverseString().reverseString("AfsVAFASD"));
  }

  public String reverseString(String A) {
    Stack<Character> stack = new Stack<>();
    for (int i=0; i<A.length(); i++) {
      stack.push(A.charAt(i));
    }

    StringBuilder stringBuilder = new StringBuilder();
    while (!stack.isEmpty()) {
      stringBuilder.append(stack.pop());
    }

    return stringBuilder.toString();
  }
}
