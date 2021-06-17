package backtracking;

import java.util.ArrayList;

public class NQueens {

  ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();

  public static void main(String[] args) {
    prind2dArr(new NQueens().solveNQueens(3));
  }

  public static void prind2dArr(ArrayList<ArrayList<String>> ans) {
    for (int i=0; i<ans.size(); i++) {
      for (int j=0; j<ans.get(0).size(); j++) {
        System.out.println(ans.get(i).get(j));
      }
      System.out.println();
    }
  }

  public ArrayList<ArrayList<String>> solveNQueens(int a) {
    ArrayList<ArrayList<Character>> config = new ArrayList<ArrayList<Character>>();
    for (int i=0; i<a; i++) {
      config.add(new ArrayList<>());
      for (int j=0; j<a; j++) {
        config.get(i).add('.');
      }
    }

    solveNQueensRecur(0, a, config);
    return ans;
  }

  public void solveNQueensRecur(
      int row, int maxRow,
      ArrayList<ArrayList<Character>> currentConfig
  ) {
    if (row == maxRow) {
      ArrayList<String> subAns = new ArrayList<String>();
      for(int i=0; i<currentConfig.size(); i++) {
        StringBuilder sb = new StringBuilder();
        for (int j=0; j<currentConfig.get(i).size(); j++) {
          sb.append(currentConfig.get(i).get(j));
        }
        subAns.add(sb.toString().replaceAll("x", "."));
      }
      ans.add(subAns);
      return;
    }

    for (int i=0; i<currentConfig.get(row).size(); i++) {
      if (checkQueenBlock(currentConfig, row, i)) {
        continue;
      }
      currentConfig.get(row).set(i, 'Q');
      solveNQueensRecur(row + 1, maxRow, currentConfig);
      currentConfig.get(row).set(i, '.');
    }
  }

  public boolean checkQueenBlock(ArrayList<ArrayList<Character>> config, int row, int col) {
    // check top
    for (int i=0; i<row; i++) {
      if (config.get(i).get(col) == 'Q') {
        return true;
      }
      if (col-row+i>=0 && config.get(i).get(col-row+i) == 'Q') {
        return true;
      }
      if (col+row-i<config.size() && config.get(i).get(col+row-i) == 'Q') {
        return true;
      }
    }

    return false;
  }
}
