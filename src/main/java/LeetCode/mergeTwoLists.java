package LeetCode;

import LeetCode.base.ListNode;

public class mergeTwoLists {

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null){
      return l2;
    }else if (l2 == null){
      return l1;
    }

    ListNode head = l1.val >= l2.val ? l2 : l1;
    ListNode chain2 = head == l1 ? l2 : l1;
    ListNode chain1 = head;


    ListNode tmp;
    while (chain1.next != null && chain2 != null){
      if (chain2.val <= chain1.next.val){
        tmp = chain2.next;
        chain2.next = chain1.next;
        chain1.next = chain2;
        chain1 = chain1.next;

        chain2 = tmp;
      }else {
        chain1 = chain1.next;
      }
    }

    if (chain2 != null){
      chain1.next = chain2;
    }


    return head;
  }

  public static void main(String[] args){
    ListNode A = new ListNode(1, new ListNode(2, new ListNode(3)));
    ListNode B = new ListNode(1, new ListNode(3, new ListNode(4)));

    System.out.println(A.toString());
    System.out.println(B.toString());

    ListNode result = new mergeTwoLists().mergeTwoLists(A, B);
    System.out.println(result.toString());
  }

}
