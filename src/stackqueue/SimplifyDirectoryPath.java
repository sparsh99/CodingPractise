package stackqueue;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SimplifyDirectoryPath {

  public static void main(String[] args) {
    System.out.println(new SimplifyDirectoryPath().simplifyPath("/home/"));
    System.out.println(new SimplifyDirectoryPath().simplifyPath("/a/./b/../../c/"));
    System.out.println(new SimplifyDirectoryPath().simplifyPath("/../"));
  }

  public String simplifyPath(String A) {
    Stack<String> stack = new Stack<>();
    List<String> path = Arrays.asList(A.split("/"));
    for (int i=0; i<path.size(); i++) {
      String current = path.get(i);
      if (current.equals("..")) {
        if (!stack.isEmpty()) {
          stack.pop();
        }
      } else if (current.equals(".") || current.equals("")) {
        // ignore
      } else {
        stack.push(current);
      }
    }
    if (stack.empty()) {
      return "/";
    }

    String ans = "";
    while (!stack.isEmpty()) {
      String current = stack.pop();
      ans = "/" + current + ans;
    }
    return ans;
  }
}
