package LeetCode;

//给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
//例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
//
//你可以按任意顺序返回答案。
//
// 
//
//示例 1：
//
//输入：["bella","label","roller"]
//输出：["e","l","l"]
//示例 2：
//
//输入：["cool","lock","cook"]
//输出：["c","o"]
// 
//
//提示：
//
//1 <= A.length <= 100
//1 <= A[i].length <= 100
//A[i][j] 是小写字母
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/find-common-characters
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
//

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class commonChars {

  public static void main(String[] arg){

    String[] A = {"bella","label","roller"};

    List reslut = new commonChars().commonChars(A);

    System.out.println(reslut.toString());
  }

  public List<String> commonChars(String[] A) {

    int[] minCharCount = getCharCount(A[0].toCharArray());
    for(int strNum = 1; strNum < A.length;strNum++){
      int[] charCount = getCharCount(A[strNum].toCharArray());
      for (int i = 0;i<26;i++){
        minCharCount[i] = Math.min(minCharCount[i],charCount[i]);
      }
    }

    List<String> resutlt = new LinkedList<>();
    for(int i=0; i< 26; i++){
      if(minCharCount[i] != 0){
        for (int j=0; j< minCharCount[i];j++){
          resutlt.add((char)(i + 'a') + "");
        }
      }
    }
    return resutlt;
  }

  public int[] getCharCount(char[] Str){
    int[] charCount = new int[26];
    for(char a : Str){
      charCount[a - 'a']++;
    }
    return charCount;
  }
}
