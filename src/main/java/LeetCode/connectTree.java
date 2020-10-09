package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

class Node {
  public int val;
  public Node left;
  public Node right;
  public Node next;

  public Node() {}

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, Node _left, Node _right, Node _next) {
    val = _val;
    left = _left;
    right = _right;
    next = _next;
  }
};

public class connectTree {
  public static void main(String[] args){
    new connectSolution().connect(null);
  }
}

class connectSolution {
  public Node connect(Node root) {
    if (root == null){return null;}
    Node cuuParentNode = root;
    Node cuuChildNode = null;

    Node zoreNode = new Node(0);
    cuuChildNode = zoreNode;
    while (cuuParentNode!= null){
      if (cuuParentNode.left != null){
        cuuChildNode.next = cuuParentNode.left;
        cuuChildNode = cuuChildNode.next;
      }

      if (cuuParentNode.right != null){
        cuuChildNode.next = cuuParentNode.left;
        cuuChildNode = cuuChildNode.next;
      }

      cuuParentNode = zoreNode.next;
      cuuChildNode.next = zoreNode;
    }
    return root;
  }
}