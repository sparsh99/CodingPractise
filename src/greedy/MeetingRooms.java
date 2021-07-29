package greedy;

import java.util.Arrays;

public class MeetingRooms {

  public static void main(String[] args) {
    System.out.println(
        new MeetingRooms().solve(
            new int[][] {
                {0, 30},
                {5, 10},
                {15, 20}
            }
        )
    );

    System.out.println(
        new MeetingRooms().solve(
            new int[][] {
                {1, 18},
                {18, 23},
                {15, 29},
                {4, 15},
                {2, 11},
                {5, 13}
            }
        )
    );
  }

  public int solve(int[][] A) {
    int[] s = new int[A.length];
    int[] e = new int[A.length];

    for (int i=0; i<A.length; i++) {
      s[i] = A[i][0];
      e[i] = A[i][1];
    }

    Arrays.sort(s);
    Arrays.sort(e);

    int i=0, j=0;
    int roomCnt = 0, maxRoomCnt = 0;
    while(i<A.length) {
      if (s[i] < e[j]) {
        roomCnt++;
        i++;
      } else {
        roomCnt--;
        j++;
      }

      if (roomCnt > maxRoomCnt) maxRoomCnt = roomCnt;
    }

    return maxRoomCnt;
  }
}
