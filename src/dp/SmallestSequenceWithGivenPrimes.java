package dp;

import java.util.ArrayList;

public class SmallestSequenceWithGivenPrimes {

  public static void main(String[] args) {
    System.out.println(new SmallestSequenceWithGivenPrimes().solve(2, 3, 5, 10));
    System.out.println(new SmallestSequenceWithGivenPrimes().solveDSq(2, 3, 5, 10));
  }

  public ArrayList<Integer> solve(int A, int B, int C, int D) {
    ArrayList<Integer> ans = new ArrayList<Integer> ();
    ans.add(1);
    int a=0, b=0, c=0;
    while (ans.size() <= D) {
      int newEntry = Math.min(A * ans.get(a), Math.min(B * ans.get(b), C * ans.get(c)));
      ans.add(newEntry);
      if (newEntry == A * ans.get(a)) a++;
      if (newEntry == B * ans.get(b)) b++;
      if (newEntry == C * ans.get(c)) c++;
    }

    ans.remove(0);
    return ans;
  }

  public ArrayList<Integer> solveDSq(int A, int B, int C, int D) {
    ArrayList<Integer> ans = new ArrayList<Integer> ();
    ans.add(1);
    for(int j=0; j<D; j++) {
      int newEntry = Integer.MAX_VALUE;
      int lastEntry = ans.get(ans.size()-1);
      for (int i=0; i<ans.size(); i++) {
        if (ans.get(i) * A > lastEntry && ans.get(i) * A < newEntry) {
          newEntry = ans.get(i) * A;
        }
        if (ans.get(i) * B > lastEntry && ans.get(i) * B < newEntry) {
          newEntry = ans.get(i) * B;
        }
        if (ans.get(i) * C > lastEntry && ans.get(i) * C < newEntry) {
          newEntry = ans.get(i) * C;
        }
      }

      ans.add(newEntry);
    }

    ans.remove(0);
    return ans;
  }
}
