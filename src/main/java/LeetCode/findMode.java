package LeetCode;

//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
//
//    假定 BST 有如下定义：
//
//    结点左子树中所含结点的值小于等于当前结点的值
//    结点右子树中所含结点的值大于等于当前结点的值
//    左子树和右子树都是二叉搜索树
//    例如：
//    给定 BST [1,null,2,2],
//
//    1
//      \
//        2
//      /
//     2
//    返回[2].
//
//    提示：如果众数超过1个，不需考虑输出顺序


import LeetCode.base.TreeNode;
import java.util.Stack;

public class findMode {
  public static void main(String[] args){
    new findModeSolution().findMode(new TreeNode(0));
  }
}

class findModeSolution {
  public int[] findMode(TreeNode root) {
    if (root == null){ return null;}
    Stack<TreeNode> tmp = new Stack();
    tmp.push(root);
    return null;
  }

}