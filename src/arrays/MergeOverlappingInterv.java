package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeOverlappingInterv {

  public static void main(String[] args) {
    System.out.println(new MergeOverlappingInterv().merge(
        new ArrayList<>(
            Arrays.asList(

            )
        )
    ));
  }

  public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
    intervals.sort(new Comparator<Interval>() {
      @Override
      public int compare(Interval o1, Interval o2) {
        if (o1.start < o2.start) {
          return -1;
        } else if (o1.start > o2.start) {
          return 1;
        } else {
          return Integer.compare(o1.end, o2.end);
        }
      }
    });

    ArrayList<Interval> ans = new ArrayList<>();
    int i=0;
    while(i<intervals.size()) {
      Interval currentInterval = intervals.get(i);
      i++;
      while(i<intervals.size() && currentInterval.end >= intervals.get(i).start) {
        currentInterval.end = Math.max(intervals.get(i).end, currentInterval.end);
        i++;
      }
      ans.add(currentInterval);
    }

    return ans;
  }

   public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
   }
}
