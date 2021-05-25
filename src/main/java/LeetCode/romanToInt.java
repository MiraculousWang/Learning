package LeetCode;

public class romanToInt {


  public static int romanToInt(String s) {
    int result = 0;
    char[] romanString = s.toCharArray();
    int pre = 0;
    for (int i = romanString.length - 1 ; i >= 0; i--){
      int key = getValue(romanString[i]);
      if (key < pre){
        result -= key;
      }else {
        result += key;
      }
      pre = key;
    }

    return result;
  }

  public static int getValue(char ch){
    switch(ch) {
      case 'I': return 1;
      case 'V': return 5;
      case 'X': return 10;
      case 'L': return 50;
      case 'C': return 100;
      case 'D': return 500;
      case 'M': return 1000;
      default: return 0;
    }
  }

  public static void main(String[] args){
    System.out.println(romanToInt("MCMXCIV"));
  }

}
