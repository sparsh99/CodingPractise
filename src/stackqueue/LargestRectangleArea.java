package stackqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LargestRectangleArea {

  public static void main(String[] args) {
    System.out.println(new LargestRectangleArea().largestRectangleArea(
        new ArrayList<>(
            Arrays.asList(2, 1, 5, 6, 2, 3)
        )
    ));
  }

  public int largestRectangleArea(ArrayList<Integer> A) {
    Stack<Integer> s = new Stack<>();
    List<Integer> maxAreas = new ArrayList<>();
    for(int i=0; i<A.size(); i++) {
      while(!s.isEmpty() && A.get(s.peek()) >= A.get(i)) {
        s.pop();
      }
      int start = (s.isEmpty()) ? i+1 : i-s.peek();
      maxAreas.add(A.get(i) * start);
      s.push(i);
    }

    int maxArea = 0;
    s.clear();
    for (int i=A.size()-1; i>=0; i--) {
      while(!s.isEmpty() && A.get(s.peek()) >= A.get(i)) {
        s.pop();
      }
      int start = (s.isEmpty()) ? A.size()-i : s.peek()-i;
      start--;
      int totalArea = maxAreas.get(i) + (A.get(i) * start);
      if (totalArea > maxArea) {
        maxArea = totalArea;
      }
      s.push(i);
    }

    return maxArea;
  }
}
