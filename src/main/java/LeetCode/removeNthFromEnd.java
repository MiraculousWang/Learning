package LeetCode;

import LeetCode.base.ListNode;
// 1 2 3 4 5

// 1 2 3 4 5 6
public class removeNthFromEnd {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode fast = head, slow = head;
    int count = 1;

    while (slow.next != null && slow.next.next !=null){
      count ++ ;
      fast = fast.next;
      slow = slow.next.next;
    }
    if (n < count){
      while (count - 1 != n){
        fast = fast.next;
      }
    }else {
      count = count * 2 - n;
      while (count > 0){

      }
    }

    return head;
  }
}
