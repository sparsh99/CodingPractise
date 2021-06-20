package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class ValidSudoku {

  public static void main(String[] args) {
    System.out.println(
        new ValidSudoku().isValidSudoku(
            Arrays.asList(
                "53..7....", "6..195...", ".98....6.", "8...6...3",
                "4..8.3..1", "7...2...6", ".6....28.", "...419..5",
                "....8..79"
            )
        )
    );
  }

  public int isValidSudoku(final List<String> A) {
    Map<Integer, HashSet<Character>> rows = new HashMap<>();
    Map<Integer, HashSet<Character>> cols = new HashMap<>();
    Map<Integer, HashSet<Character>> box = new HashMap<>();

    for (int i=0; i<9; i++) {
      rows.put(i, new HashSet<>());
      cols.put(i, new HashSet<>());
      box.put(i, new HashSet<>());
    }

    for (int i=0; i<9; i++) {
      for (int j=0; j<9; j++) {
        if (A.get(i).charAt(j) == '.') {
          continue;
        }

        if (rows.get(i).contains(A.get(i).charAt(j))) {
          return 0;
        }

        if (cols.get(j).contains(A.get(i).charAt(j))) {
          return 0;
        }

        int boxNo = (i/3) * 3 + (j/3);
        if (box.get(boxNo).contains(A.get(i).charAt(j))) {
          return 0;
        }

        rows.get(i).add(A.get(i).charAt(j));
        cols.get(j).add(A.get(i).charAt(j));
        box.get(boxNo).add(A.get(i).charAt(j));
      }
    }

    return 1;
  }

}
