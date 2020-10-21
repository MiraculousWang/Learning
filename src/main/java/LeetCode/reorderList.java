package LeetCode;

// 143. 重排链表
//
//给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
//
//你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//示例 1:
//
//给定链表 1->2->3->4, 重新排列为 1->4->2->3.
//示例 2:
//
//给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/reorder-list
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



import LeetCode.base.ListNode;
import java.util.Stack;

// 解
public class reorderList {

  public static void main(String[] args){
    ListNode head = new ListNode(1);
    ListNode tmp = head;
    tmp.next = new ListNode(2);tmp = tmp.next;
    tmp.next = new ListNode(3);tmp = tmp.next;
    tmp.next = new ListNode(4);tmp = tmp.next;
//    tmp.next = new ListNode(5);tmp = tmp.next;
//    tmp.next = new ListNode(6);tmp = tmp.next;
//    tmp.next = new ListNode(7);tmp = tmp.next;



    new reorderList().reorderList2(head);
    return;
  }

  public void reorderList(ListNode head) {

    ListNode next = head;
    if (next == null){ return; }

    Stack<ListNode> stack = new Stack<>();
    while(next !=null){
      stack.push(next);
      next = next.next;
    }

    next = head;
    while (next != stack.peek() && stack.peek().next != next){
      ListNode cuu = stack.pop();
      cuu.next = next.next;
      next.next = cuu;

      next = cuu.next;
    }
    next.next = null;
  }


  // 进阶：
  // 1.快慢指针找到链表中点
  // 2.拆分两个链表，并倒至第二个链表
  // 3.合并两个链表
  public void reorderList2(ListNode head) {

    // 快慢指针找到链表中点
    if (head == null || head.next == null){return;}
    ListNode fast = head;
    ListNode slow = head;

    while (fast.next != null && fast.next.next != null){
      fast = fast.next.next;
      slow = slow.next;
    }

    // 拆分两个链表
    ListNode head2 = slow.next;
    slow.next = null;

    // 倒置第二个链表
    ListNode tmp;
    ListNode nextNode = head2.next;
    head2.next = null;

    while (nextNode != null){
      tmp = nextNode;
      nextNode = nextNode.next;

      tmp.next = head2;
      head2 = tmp;

    }
    // 合并两个链表
    ListNode head1 = head;
    while (head2 !=null){
      tmp = head2;
      head2 = head2.next;

      tmp.next = head1.next;
      head1.next = tmp;
      head1 = head1.next.next;
    }
  }
}
