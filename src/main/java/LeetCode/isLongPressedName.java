package LeetCode;

//925. 长按键入
//你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
//
//你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
//
// 
//
//示例 1：
//
//输入：name = "alex", typed = "aaleex"
//输出：true
//解释：'alex' 中的 'a' 和 'e' 被长按。
//示例 2：
//
//输入：name = "saeed", typed = "ssaaedd"
//输出：false
//解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
//示例 3：
//
//输入：name = "leelee", typed = "lleeelee"
//输出：true
//示例 4：
//
//输入：name = "laiden", typed = "laiden"
//输出：true
//解释：长按名字中的字符并不是必要的。
// 
//
//提示：
//
//name.length <= 1000
//typed.length <= 1000
//name 和 typed 的字符都是小写字母。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/long-pressed-name
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
//

public class isLongPressedName {

  public static void main(String[] args){
    System.out.println(new isLongPressedName().isLongPressedName("leelee",
        "lleeelee"));

    System.out.println(new isLongPressedName().isLongPressedName("alex",
        "alexxr"));
  }
  // 解
  // 吐血，测试用例是真的多 提交了7次才通过
  public boolean isLongPressedName(String name, String typed) {

    if (name .equals("") || typed.equals("")){ return false; }

    int nameChar = 0;
    int exitFlag = 0;
    char beforeC = name.charAt(nameChar);

    for (int i = 0; i < typed.length(); i++){
     if (exitFlag == 0){
       if (typed.charAt(i) == beforeC){
         exitFlag++;
       }else {
         return false;
       }
     }else {
       if (typed.charAt(i) == beforeC){ exitFlag++;continue; }
       else {
         if(++nameChar >= name.length()){return false;}

         while (beforeC == name.charAt(nameChar)){
           if (exitFlag <= 1){
             return false;
           }else{
             exitFlag--;
           }
           if(++nameChar >= name.length()){return false;}
         }
         beforeC = name.charAt(nameChar);

         if (typed.charAt(i) == beforeC){
           exitFlag = 1;
         }else {
           return false;
         }
       }
     }
    }

    for(int i = nameChar;i < name.length();i++){
      if (beforeC == name.charAt(i)){exitFlag--;}
      else {return false;}
    }
    if (exitFlag < 0){return false;}
    return true;
  }

  // 看了答案 直接快猝死了 逻辑原来就这么简单！！！！
  public boolean isLongPressedName2(String name, String typed) {
    int i = 0, j = 0;
    while (j < typed.length()) {
      if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
        i++;
        j++;
      } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
        j++;
      } else {
        return false;
      }
    }
    return i == name.length();
  }

}
