package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HotelReviewsTrie {

  public ArrayList<Integer> solve(String A, ArrayList<String> B) {
    String[] goodWords = A.split("_");
    TrieNode root = new TrieNode();
    // build trie
    for (String goodWord: goodWords) {
      TrieNode current = root;
      for (Character ch: goodWord.toCharArray()) {
        if (!current.charMap.containsKey(ch)) {
          current.charMap.put(ch, new TrieNode());
        }
        current = current.charMap.get(ch);
      }

      current.isValid = true;
    }

    Map<Integer, ArrayList<Integer>> scoresMap = new HashMap<>();
    int pos = 0;
    for (String line: B) {
      String[] words = line.split("_");
      int score = 0;
      for (String word: words) {
        TrieNode current = root;
        for (Character ch: word.toCharArray()) {
          current = current.charMap.get(ch);
          if (current == null) break;
        }

        if (current != null && current.isValid)
          score++;
      }

      if (!scoresMap.containsKey(score)) {
        scoresMap.put(score, new ArrayList<>());
      }
      scoresMap.get(score).add(pos);
      pos++;
    }

    ArrayList<Integer> scoresPos = new ArrayList<Integer>(scoresMap.keySet());
    Collections.sort(scoresPos);
    ArrayList<Integer> ans = new ArrayList<Integer>();
    for (int i=scoresPos.size()-1; i>=0; i--) {
      ans.addAll(scoresMap.get(scoresPos.get(i)));
    }

    return ans;
  }

  private class TrieNode {
    Map<Character, TrieNode> charMap;
    boolean isValid;

    public TrieNode() {
      charMap = new HashMap<>();
      isValid = false;
    }
  }
}
