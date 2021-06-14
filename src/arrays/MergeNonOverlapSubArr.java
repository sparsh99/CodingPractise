package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeNonOverlapSubArr {

  public static void main(String[] args) {
        /*
    A : [ (6037774, 6198243), (6726550, 7004541), (8842554, 10866536), (11027721, 11341296), (11972532, 14746848), (16374805, 16706396), (17557262, 20518214), (22139780, 22379559), (27212352, 28404611), (28921768, 29621583), (29823256, 32060921), (33950165, 36418956), (37225039, 37785557), (40087908, 41184444), (41922814, 45297414), (48142402, 48244133), (48622983, 50443163), (50898369, 55612831), (57030757, 58120901), (59772759, 59943999), (61141939, 64859907), (65277782, 65296274), (67497842, 68386607), (70414085, 73339545), (73896106, 75605861), (79672668, 84539434), (84821550, 86558001), (91116470, 92198054), (96147808, 98979097) ]
    B : (36210193, 61984219)

     */

        new MergeNonOverlapSubArr().insert(
            new ArrayList<>(Arrays.asList(
                new Interval(1,2),
                new Interval(8, 10)
            )),
            new Interval(3, 6)
        );
  }

  public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

    if (newInterval.start > newInterval.end) {
      int temp = newInterval.end;
      newInterval.end = newInterval.start;
      newInterval.start = temp;
    }

    if (intervals.size() == 0) {
      return new ArrayList<Interval>(Arrays.asList(newInterval));
    }

    int start = -1;
    int end = -1;
    for (int i=0; i<intervals.size(); i++) {
      if (start == -1
          && (newInterval.start < intervals.get(i).start
          || (intervals.get(i).start <= newInterval.start
          && intervals.get(i).end >= newInterval.start))
      ) {
        start = i;
      }

      if (start != -1
          && (newInterval.end > intervals.get(i).end
          || (intervals.get(i).start <= newInterval.end
          && intervals.get(i).end >= newInterval.end))
      ) {
        end = i;
      }
    }

    ArrayList<Interval> ans = new ArrayList<Interval>();
    if (intervals.get(0).start > newInterval.end) {
      ans.add(newInterval);
      ans.addAll(intervals);
    } else if (intervals.get(intervals.size()-1).start < newInterval.start) {
      ans.addAll(intervals);
      ans.add(newInterval);
    } else { // merge
      ans.addAll(intervals.subList(0, start));

      if (start == -1 || end == -1) {
        ans.add(newInterval);
        end = start - 1;
      } else {
        ans.add(new Interval(
            Math.min(intervals.get(start).start, newInterval.start),
            Math.max(intervals.get(end).end, newInterval.end)
        ));
      }

      ans.addAll(intervals.subList(end+1, intervals.size()));
    }

    return ans;
  }

  public static class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
  }
}
