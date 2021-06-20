package heapsandmaps;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

  public static void main(String[] args) {
//    run("6 1 S 2 1 S 2 2 G 2 S 1 1 S 4 1 G 2");
//    run("32 4 S 5 13 S 9 6 S 4 1 G 4 S 6 1 S 8 11 G 13 G "
//        + "1 S 12 12 G 10 S 15 13 S 2 13 S 7 5 S 10 3 G 6 G 10 S 15"
//        + " 14 S 5 12 G 5 G 7 G 15 G 5 G 6 G 10 S 7 13 G 14 S 8 9 G "
//        + "4 S 6 11 G 9 S 6 12 G 3");
//    run("6 2 S 2 1 S 1 1 S 2 3 S 4 1 G 1 G 2");
    run("59 7 S 2 1 S 1 10 S 8 13 G 12 S 2 8 G 11 G 7 S 14 7 S 12 9 S 7 10 G "
        + "11 S 9 3 S 14 15 G 15 G 9 S 4 13 G 3 S 13 7 G 2 S 5 9 G 6 G 13 S 4 5 S 3 2 "
        + "S 4 12 G 13 G 7 S 9 7 G 3 G 6 G 2 S 8 4 S 8 9 S 1 4 S 2 9 S 8 8 G 13 G 3 G "
        + "13 G 6 S 3 8 G 14 G 4 S 5 6 S 10 15 G 12 S 13 5 S 10 9 S 3 12 S 14 15 G 4 S "
        + "10 5 G 5 G 15 S 7 6 G 1 S 5 12 S 1 6 S 11 8");
  }

  public static void run(String arg) {
    String[] arguments = arg.split(" ");
    int noOfOp = Integer.valueOf(arguments[0]);
    int capacity = Integer.valueOf(arguments[1]);
    int i = 2;
    LRUCache lruCache = new LRUCache(capacity);
    while (i < arguments.length) {
      String opn = arguments[i];
      if (opn.equals("S")) {
        int n1 = Integer.valueOf(arguments[i + 1]);
        int n2 = Integer.valueOf(arguments[i + 2]);
        lruCache.set(n1, n2);
        i+=3;
      } else {
        int n1 = Integer.valueOf(arguments[i + 1]);
        System.out.println(lruCache.get(n1));
        i+=2;
      }
    }
  }

  int capacity;
  Map<Integer, DoubleEndedQueueNode> dataMap;
//  DoubleEndedQueueNode head;
//  DoubleEndedQueueNode tail;
  Deque dq;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.dataMap = new HashMap<>();
//    this.head = null;
//    this.tail = null;
    this.dq = new Deque();
  }

  public int get(int key) {
    if (dataMap.containsKey(key)) {
      DoubleEndedQueueNode dqn = dataMap.get(key);
//      if (dqn.left != null) {
//        dqn.left.right = dqn.right;
//        if (dqn.right != null) {
//          dqn.right.left = dqn.left;
//        }
//        dqn.left = null;
//        dqn.right = head;
//        head = dqn;
//      }
      dq.moveNodeToHead(dqn);
      return dqn.val;
    }

    return -1;
  }

  public void set(int key, int value) {
    if (dataMap.containsKey(key)) {
      DoubleEndedQueueNode dqn = dataMap.get(key);
      dqn.val = value;
      dq.moveNodeToHead(dqn);
    } else {
      if (dataMap.keySet().size() == capacity) {
        dq.deleteTail();
      }

      DoubleEndedQueueNode dqn = new DoubleEndedQueueNode();
      dqn.key = key;
      dqn.val = value;
      dq.addNodeToHead(dqn);
      dataMap.put(key, dqn);
    }

//    if (dataMap.containsKey(key)) {
//      DoubleEndedQueueNode dqn = dataMap.get(key);
//      dqn.val = value;
//      if (dqn.left != null) {
//        dqn.left.right = dqn.right;
//        if (dqn.right != null) {
//          dqn.right.left = dqn.left;
//        } else {
//          tail = dqn.left;
//          tail.right = null;
//        }
//        dqn.left = null;
//        dqn.right = head;
//        head.left = dqn;
//        head = dqn;
//      }
//    } else {
//      DoubleEndedQueueNode dqn = new DoubleEndedQueueNode();
//      dataMap.put(key, dqn);
//      dqn.key = key;
//      dqn.val = value;
//      dqn.right = head;
//      if (head != null) {
//        head.left = dqn;
//      }
//      head = dqn;
//      if (tail == null) {
//        tail = dqn;
//      }
//
//      if (dataMap.keySet().size() > capacity) {
//        dataMap.remove(tail.key);
//        tail = tail.left;
//        if (tail != null)
//          tail.right = null;
//      }
//    }
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
  }

  public static class DoubleEndedQueueNode {
    DoubleEndedQueueNode left;
    DoubleEndedQueueNode right;
    Integer key;
    Integer val;
  }
}
