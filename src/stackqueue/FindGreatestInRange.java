package stackqueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class FindGreatestInRange {

  public static void main(String[] args) {
    List<Integer> arr = Arrays.asList(
        10, 9, 8, 7, 6, 5, 4, 3, 2, 1
    );
    System.out.println(
        new FindGreatestInRange().slidingMaximum(new ArrayList<Integer>(arr), 2));
  }


  public static class Pair {
    public Pair(Integer k, Integer v) {
      this.key = k;
      this.value = v;
    }
    public Integer key;
    public Integer value;
  }

  public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
    Deque<Pair> greaterStack = new ArrayDeque<>();
    Integer currentGreatest = A.get(0);
    ArrayList<Integer> ans = new ArrayList<>();

    for (int i=0; i<B; i++) {
      while(greaterStack.size() > 0 && greaterStack.peekLast().key < A.get(i)) {
        greaterStack.pollLast();
      }

      if(greaterStack.isEmpty()) {
        currentGreatest = A.get(i);
      }

      greaterStack.addLast(new Pair(A.get(i), i));
    }

    ans.add(greaterStack.peekFirst().key);

    for (int i=B; i<A.size(); i++) {
      while(greaterStack.size() > 0
          && (greaterStack.peekLast().key < A.get(i))) {
        greaterStack.pollLast();
      }

      while(greaterStack.size() > 0
          && (greaterStack.peekFirst().value <= i-B)) {
        greaterStack.pollFirst();
      }

      greaterStack.addLast(new Pair(A.get(i),i));
      ans.add(greaterStack.peekFirst().key);
    }

    return ans;
  }

}
