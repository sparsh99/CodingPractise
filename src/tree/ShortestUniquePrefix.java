package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ShortestUniquePrefix {

  public static void main(String[] args) {
    System.out.println(new ShortestUniquePrefix()
        .prefix(new ArrayList<>(Arrays.asList("zebra", "dog", "duck", "dove"))));

  }

  public ArrayList<String> prefix(ArrayList<String> A) {
    TrieNode root = buildTrie(A);
    ArrayList<String> ans = new ArrayList<String>();
    for (String a : A) {
      TrieNode current = root;
      String currentPrefix = "";
      String lastValidPrefix = null;

      for (Character c: a.toCharArray()) {
        current = current.m.get(c);
        currentPrefix += c;
        if (!a.equals(currentPrefix) && (current.isValid || current.m.size() > 1)) {
          lastValidPrefix = null;
        } else if (lastValidPrefix == null) {
          lastValidPrefix = currentPrefix;
        }
      }
      ans.add(lastValidPrefix);
    }

    return ans;
  }

  public TrieNode buildTrie(ArrayList<String> A) {
    TrieNode root = new TrieNode();
    for (String a : A) {
      TrieNode current = root;
      for (Character c: a.toCharArray()) {
        if (!current.m.containsKey(c)) {
          current.m.put(c, new TrieNode());
        }
        current = current.m.get(c);
      }
      current.isValid = true;
    }

    return root;
  }

  public class TrieNode {
    public Map<Character, TrieNode> m;
    public boolean isValid;

    public TrieNode() {
      m = new HashMap<>();
      isValid = false;
    }
  }
}
