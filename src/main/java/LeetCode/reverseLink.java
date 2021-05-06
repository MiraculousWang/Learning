package LeetCode;

public class reverseLink {

  public static void main(String[] args) throws InterruptedException {

    Node A = new Node(1,new Node(2,new Node(3,new Node(4, new Node(5, new Node(6))))));

    Node result = new reverseLink().reverse(A);

    while (result !=null ){
      System.out.println(result.val);
      result = result.next;
      Thread.sleep(100);
    }
  }

  private Node reverse(Node a) {
    if(a==null || a.next == null){
      return a;
    }

    Node pre = a;
    Node cur = a.next;
    Node Next = cur.next;

    pre.next = null;
    while (Next != null){
      cur.next = pre;

      pre = cur;
      cur = Next;
      Next = Next.next;
    }
    cur.next = pre;

    return cur;
  }


}