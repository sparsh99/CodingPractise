package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import stackqueue.FindGreatestInRange.Pair;

public class TusharsBirthdayParty {

  public static void main(String[] args) {
    System.out.println(new TusharsBirthdayParty().solve(
        10, new ArrayList<>(Arrays.asList(8, 8, 6, 5, 4))
    ));

    System.out.println(new TusharsBirthdayParty().solve(
        5277, new ArrayList<>(Arrays.asList(1594, 21484, 22020,
            8007, 5610, 15136, 15315, 1427, 10551, 11183, 6376,
            6656, 7362, 24332, 8512, 18976, 1486, 19227, 9478,
            11235, 3703, 18455, 7973, 9314, 23933, 24981, 8869,
            22788, 5736, 24146, 18734, 23673, 11973, 15745, 23024,
            17575, 22224, 13330, 18993, 24118, 24504, 361, 5766,
            23210, 16036, 14269, 8529, 8865, 24840, 17999, 20091,
            3534, 2797, 3055, 4192, 1721, 19379, 13052, 24500,
            16458, 3541, 18225, 6475, 15506, 313, 4490, 8072,
            13880, 9163, 18408, 12990, 10, 18760, 10099, 23211,
            1140, 15711, 23084, 9996, 15542, 16074, 5079, 10420,
            10214, 24477, 5955, 11926, 10200, 18998, 2769, 18001,
            13882, 12338))
    ));
  }

  public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
    int min = Integer.MAX_VALUE;
    for (int i=0; i<B.size(); i++) {
      if (min > B.get(i)) {
        min = B.get(i);
      }
    }

    ArrayList<Integer> ans = new ArrayList<Integer>();
    int i=0;
    while (i < B.size()) {
      if (A >= B.get(i) && 1+(A-B.get(i))/min == A/min) {
        ans.add(i);
        A -= B.get(i);
      } else {
        i++;
      }
    }

    return ans;
  }

//
//  public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
//
//    ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
//    for (int i=0; i<=A; i++) {
//      dp.add(new ArrayList<>());
//
//      for (int j=0; j<B.size(); j++) {
//        for (int k=1; k<=i/B.get(j); k++) {
//
//          if (i-(B.get(j)*k) >= 0
//              && dp.get(i).size() <= dp.get(i-(B.get(j)*k)).size() + k) {
//
//            ArrayList<Integer> temp = new ArrayList<>();
//            temp.addAll(dp.get(i-(B.get(j)*k)));
//            for (int m=0; m<k; m++) temp.add(j);
//
//            if (temp.size() == dp.get(i).size()
//                && isLexicographicAhead(dp.get(i), temp)) {
//              // do nothing
//            } else {
//              dp.set(i, temp);
//            }
//          }
//        }
//      }
//    }
//
//    return dp.get(A);
//  }
//
//  public boolean isLexicographicAhead(ArrayList<Integer> a , ArrayList<Integer> b) {
//    if (a.size() < b.size()) return false;
//    else if (a.size() > b.size()) return false;
//
//    int i=0;
//    while(i < a.size() && a.get(i) == b.get(i)) {
//      i++;
//    }
//
//    if (a.size() == i) return true;
//
//    return (a.get(i) < b.get(i));
//  }
}
