package LeetCode;

// 根据一棵树的中序遍历与后序遍历构造二叉树。
//
//注意:
//你可以假设树中没有重复的元素。
//
//例如，给出
//
//中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3]
//返回如下的二叉树：
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//

import LeetCode.base.TreeNode;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class buildTree {

  public TreeNode buildTree(int[] inorder, int[] postorder){
    if (inorder == null || postorder == null){return null;}
    TreeNode root = new TreeNode(postorder[postorder.length - 1]);
    HashMap<Integer,Integer> indexMap = new HashMap<>();
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    for (int i = 0;i<inorder.length;i++){ indexMap.put(inorder[i],i); }
    int cuuRootIndex = indexMap.get(root.val);

    TreeNode cuuNode = root;

   for (int i = postorder.length - 2 ;i > 0; i--){
     int cuuIndex = indexMap.get(postorder[i]);
     if(cuuIndex > cuuRootIndex){
       cuuNode.right = new TreeNode(postorder[i]);
       cuuNode = cuuNode.right;
       cuuRootIndex = cuuIndex;

       stack.push(cuuNode);
     } else {
       cuuNode = stack.pop();

       while (!stack.empty() && indexMap.get(stack.peek().val) > cuuIndex){
         cuuNode = stack.pop();
         cuuRootIndex = indexMap.get(cuuNode.val);
       }
       cuuNode.left = new TreeNode(postorder[i]);
       stack.push(cuuNode.left);
     }
   }
    return root;
  }



  public TreeNode buildTree1(int[] inorder, int[] postorder) {
    if (postorder == null || postorder.length == 0) {
      return null;
    }
    TreeNode root = new TreeNode(postorder[postorder.length - 1]);
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    stack.push(root);
    int inorderIndex = inorder.length - 1;
    for (int i = postorder.length - 2; i >= 0; i--) {
      int postorderVal = postorder[i];
      TreeNode node = stack.peek();
      if (node.val != inorder[inorderIndex]) {
        node.right = new TreeNode(postorderVal);
        stack.push(node.right);
      } else {
        while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
          node = stack.pop();
          inorderIndex--;
        }
        node.left = new TreeNode(postorderVal);
        stack.push(node.left);
      }
    }
    return root;
  }

}
