package LeetCode;

public class reverseInteger {

  public static void main(String[] args){
    System.out.println(new reverseInteger().reverseTest(-214748364));

  }

  public int reverseTest(int x) {
    if (x == -2147483648){ return 0; }

    int flag = x > 0 ? 1 : -1 ;
    char[] value = (x * flag + "").toCharArray();
    int index = 0;
    int length = value.length - 1;
    while (index <= length/2){
      char tmp = value[index];
      value[index] = value[length - index];
      value[length - index] = tmp;
      index ++ ;
    }

    "".indexOf(1);
    try {
      return Integer.valueOf(String.valueOf(value)) * flag;
    } catch (NumberFormatException NFE){
      return 0;
    }
  }
}
