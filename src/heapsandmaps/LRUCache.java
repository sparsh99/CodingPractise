package heapsandmaps;

import java.util.HashMap;
import java.util.Map;
import linkedlist.ListNode;

public class LRUCache {

  public static void main(String[] args) {
//    run("6 1 S 2 1 S 2 2 G 2 S 1 1 S 4 1 G 2");
//    run("32 4 S 5 13 S 9 6 S 4 1 G 4 S 6 1 S 8 11 G 13 G "
//        + "1 S 12 12 G 10 S 15 13 S 2 13 S 7 5 S 10 3 G 6 G 10 S 15"
//        + " 14 S 5 12 G 5 G 7 G 15 G 5 G 6 G 10 S 7 13 G 14 S 8 9 G "
//        + "4 S 6 11 G 9 S 6 12 G 3");
//    run("6 2 S 2 1 S 1 1 S 2 3 S 4 1 G 1 G 2");
    System.out.println(run("95 11 S 1 1 G 11 G 11 S 3 10 G 10 S 3 12 S 1 15 S 4 12 G 15 S 8 6 S "
        + "5 3 G 2 G 12 G 10 S 11 5 G 7 S 5 1 S 15 5 G 2 S 13 8 G 3 S 14 2 S 12 11 "
        + "S 7 10 S 5 4 G 9 G 2 S 13 5 S 10 14 S 9 11 G 5 S 13 11 S 8 12 G 10 S 5 "
        + "12 G 8 G 11 G 8 S 9 11 S 10 6 S 7 12 S 1 7 G 10 G 9 G 15 G 15 G 3 S 15 "
        + "4 G 10 G 14 G 10 G 12 G 12 S 14 7 G 11 S 9 10 S 6 12 S 14 11 G 3 S 7 5 "
        + "S 1 14 S 2 8 S 11 12 S 8 4 G 3 S 13 15 S 1 4 S 5 3 G 3 G 9 G 14 G 9 S "
        + "13 10 G 14 S 3 9 G 8 S 3 5 S 6 4 S 10 3 S 11 13 G 8 G 4 S 2 11 G 2 G 9 "
        + "S 15 1 G 9 S 7 8 S 4 3 G 3 G 1 S 8 4 G 13 S 1 2 G 3"));
    System.out.println("-1 -1 -1 -1 -1 -1 -1 -1 -1 12 -1 -1 4 14 12 5 12 6 11 -1 -1 12 6 -1 "
        + "6 11 11 5 12 12 12 10 11 10 11 4 4 -1 11 10 10 5 -1 -1 5");
  }

  public static String run(String arg) {
    String[] arguments = arg.split(" ");
    int noOfOp = Integer.valueOf(arguments[0]);
    int capacity = Integer.valueOf(arguments[1]);
    int i = 2;
    LRUCache lruCache = new LRUCache(capacity);
    String ans = "";
    while (i < arguments.length) {
      String opn = arguments[i];
      if (opn.equals("S")) {
        int n1 = Integer.valueOf(arguments[i + 1]);
        int n2 = Integer.valueOf(arguments[i + 2]);
        lruCache.set(n1, n2);
        i+=3;
      } else {
        int n1 = Integer.valueOf(arguments[i + 1]);
        ans += lruCache.get(n1) + " ";
        i+=2;
      }
    }

    return ans;
  }

  int capacity;
  Map<Integer, DoubleEndedQueueNode> dataMap;
  Deque dq;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.dataMap = new HashMap<>();
    this.dq = new Deque();
  }

  public int get(int key) {

    System.out.print("[G " + key + "] ");

    if (dataMap.containsKey(key)) {
      DoubleEndedQueueNode dqn = dataMap.get(key);
      dq.moveNodeToHead(dqn);
      dq.printList(capacity);
      return dqn.val;
    }

    dq.printList(capacity);
    return -1;
  }

  public void set(int key, int value) {

    System.out.print("[S " + key + ", " + value + "] ");

    if (dataMap.containsKey(key)) {
      DoubleEndedQueueNode dqn = dataMap.get(key);
      dqn.val = value;
      dq.moveNodeToHead(dqn);
    } else {
      if (dataMap.keySet().size() == capacity) {
        dataMap.remove(dq.tail.key);
        dq.deleteTail();
      }

      DoubleEndedQueueNode dqn = new DoubleEndedQueueNode();
      dqn.key = key;
      dqn.val = value;
      dq.addNodeToHead(dqn);
      dataMap.put(key, dqn);
    }

    dq.printList(capacity);
  }

  public static class Deque {
    DoubleEndedQueueNode head;
    DoubleEndedQueueNode tail;

    public void addNodeToHead(DoubleEndedQueueNode node) {
      if (head == null) {
        head = node;
        tail = node;
      } else {
        node.right = head;
        head.left = node;
        head = node;
      }
    }

    public void moveNodeToHead(DoubleEndedQueueNode node) {
      DoubleEndedQueueNode left = node.left;
      DoubleEndedQueueNode right = node.right;

      if (left == null) { // already head
        return;
      }

      left.right = right;

      if (right == null) {
        tail = left;
      } else {
        right.left = left;
      }

      node.right = head;
      node.left = null;
      head.left = node;
      head = node;
    }

    public void deleteTail() {
      if (tail.left == null) {
        head = null;
        tail = null;
      } else {
        tail.left.right = null;
        tail = tail.left;
      }
    }

    public void printList(int capacity) {
      DoubleEndedQueueNode node = head;
      while (node != null && capacity > 0) {
        System.out.print(node.key + "["
            + (node.left != null ? node.left.key : null) + ", "
            + (node.right != null ? node.right.key : null) + "]");
        if (node.right != null) {
          System.out.print(" -> ");
        }
        node = node.right;
        capacity --;
      }
      System.out.println();
    }
  }

  public static class DoubleEndedQueueNode {
    DoubleEndedQueueNode left;
    DoubleEndedQueueNode right;
    Integer key;
    Integer val;
  }
}
