package LeetCode;

import LeetCode.base.ListNode;
import java.util.List;

/*
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

 

示例 1：


输入：head = [1,2,3,4]
输出：[2,1,4,3]
示例 2：

输入：head = []
输出：[]
示例 3：

输入：head = [1]
输出：[1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */



public class swapPairs {

  // 非递归写法
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null){return head;}

    ListNode ResultHead = new ListNode(0);
    ResultHead.next = head;


    ListNode NodeA = head;
    ListNode NodeB,Pre;
    Pre = ResultHead;

    while (NodeA != null && NodeA.next != null){
      NodeB = NodeA.next;

      NodeA.next = NodeB.next;
      NodeB.next = NodeA;
      Pre.next = NodeB;

      Pre = NodeA;
      NodeA = NodeA.next;

    }
    return ResultHead.next;
  }

  // 最简洁递归写法
  public ListNode swapPairs2(ListNode head){
    if (head != null && head.next != null){
      ListNode ret = head.next;
      head.next = swapPairs2(ret.next);
      ret.next = head;
      return ret;
    }
    return head;
  }

}
