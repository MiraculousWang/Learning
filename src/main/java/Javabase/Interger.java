package Javabase;

public class Interger {

  public static void main(String[] args){
    Integer a = new Integer(5);
    Integer b = new Integer(5);

    int c = 5;
    Integer d = 5;

    Integer e = 128;
    Integer f = 128;


    System.out.println(a == b);  // false

    // Integer和 int 使用" == "时，Integer会自动拆箱
    System.out.println(b == c);  // true
    System.out.println(c == d);  // true

    // value 在【-128，127】 时，自动装箱使用内部静态变量IntegerCache 的对象
    System.out.println(d == b);  // false
    System.out.println(e == f);  // false

    // 先取d.intValue(),再相加，最后再调用valueof(int),返回内部静态变量IntegerCache 的对象
    Integer g = d + 1;
    Integer h = 6;

    System.out.println(g == h);



  }

}
