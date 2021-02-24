package LeetCode;


//844. 比较含退格的字符串
//给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
//
//注意：如果对空文本输入退格字符，文本继续为空。
//
// 
//
//示例 1：
//
//输入：S = "ab#c", T = "ad#c"
//输出：true
//解释：S 和 T 都会变成 “ac”。
//示例 2：
//
//输入：S = "ab##", T = "c#d#"
//输出：true
//解释：S 和 T 都会变成 “”。
//示例 3：
//
//输入：S = "a##c", T = "#a#c"
//输出：true
//解释：S 和 T 都会变成 “c”。
//示例 4：
//
//输入：S = "a#c", T = "b"
//输出：false
//解释：S 会变成 “c”，但 T 仍然是 “b”。
// 
//
//提示：
//
//1 <= S.length <= 200
//1 <= T.length <= 200
//S 和 T 只含有小写字母以及字符 '#'。
// 
//
//进阶：
//
//你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/backspace-string-compare
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
//


import java.util.LinkedList;
import java.util.List;

public class backspaceCompare {

  public static void main(String[] args){
    System.out.println(new backspaceCompare().backspaceCompare("bxj##tw","bxj###tw"));
  }

  // 解
  public boolean backspaceCompare(String S, String T) {

    int SIndex = S.length() -1;
    int TIndex = T.length() -1;

    int Sdel = 0;
    int Tdel = 0;

    while (SIndex >= 0 && TIndex >= 0){
      while (S.charAt(SIndex) == '#'){ Sdel++;SIndex--; }
      while (T.charAt(TIndex) == '#'){ Tdel++;TIndex--; }
      if (Sdel > 0){ SIndex--; Sdel--; continue;}
      if (Tdel > 0){ TIndex--; Tdel--; continue;}

      if (S.charAt(SIndex) != T.charAt(TIndex)){return false;}

      SIndex--;
      TIndex--;
    }

    if (TIndex < 0){
      while (SIndex >= 0){
        if (S.charAt(SIndex) == '#'){ Sdel++;SIndex--; continue;}
        if (Sdel > 0){ SIndex--; Sdel--; continue;}
        return false;
      }
    }
    // #a#c
    if (SIndex < 0){
      while (TIndex >= 0){
        if (T.charAt(TIndex) == '#'){ Tdel++;TIndex--; continue;}
        if (Tdel > 0){ TIndex--; Tdel--; continue;}
        return false;
      }
    }

    return true;
  }

  public static class addtoarrayformofinteger {
    public List<Integer> addToArrayForm(int[] A, int K) {
      LinkedList<Integer> resultList = new LinkedList<Integer>();

      int index = A.length - 1;
      while(K != 0 || index >= 0){
        int AddNum = K - K/10*10;
        K = K/10;

        if (index >= 0){
          int head = AddNum + A[index--];
          if (head >= 10){ K++;}
          resultList.addFirst(head % 10);
        }else {
          resultList.add(AddNum);
        }
      }

      return resultList;
    }

    public static void main(String[] args){
      int A[] = {9,9,9,9};
      System.out.println(new addtoarrayformofinteger().addToArrayForm(A,34).toString());
    }

  }
}
