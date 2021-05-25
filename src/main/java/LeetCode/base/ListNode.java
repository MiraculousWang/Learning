package LeetCode.base;


public class ListNode {
  public int val;
  public ListNode next;
  public ListNode(int x) {
    val = x;
    next = null;
  }

  public ListNode(int x, ListNode n) {
    this.val = x;
    this.next = n;
  }

  public String toString(){
    String result = "[ ";
    ListNode A = this;
    while (A!=null){
      result = result +  A.val + ",";
      A = A.next;
    }
    return result + " ]";
  }

}
