package Javabase;


/*
类的实例化顺序，比如父类静态数据，构造函数，字段，子类静态数据，构造函数，字段，他们的执行顺序

    答：先静态、先父后子。
    先静态：父静态 > 子静态
    优先级：父类 > 子类 静态代码块 > 非静态代码块 > 构造函数
    一个类的实例化过程：
    1，父类中的static代码块，当前类的static
    2，顺序执行父类的普通代码块
    3，父类的构造函数
    4，子类普通代码块
    5，子类（当前类）的构造函数，按顺序执行。
    6，子类方法的执行，
*/


import java.security.PublicKey;

class staticFather{

  public String PublicStr = "Father Public Str";
  private String PrivateStr = "Father Privite Str";
  protected String ProtectedStr = "Father Protected Str";

  static {
    System.out.println("Father Static code block ");
  }

  {
    System.out.println("Father code block");
  }

  staticFather(){
    System.out.println("Father constructor Fuction");
  }

}


class staticSon extends staticFather{

//  public String PublicStr = "Son Str";
//  private String PrivateStr = "Son Privite Str";
//  protected String ProtectedStr = "Son Protected Str";


  static {
    System.out.println("Son Static code block ");
  }

  {
    System.out.println("Son code block");
  }

  staticSon(){
    System.out.println("Son constructor Fuction");
  }

  public void printStr(){
    System.out.println(PublicStr);
//    System.out.println(PrivateStr);
    System.out.println(ProtectedStr);
  }

}

public class staticLoad {

//  打印顺序
//  Father Static code block
//  Son Static code block
//  Father code block
//  Father constructor Fuction
//  Son code block
//  Son constructor Fuction
//  Father Public Str
//  Father Protected Str

  public static void main(String[] args ){
    new staticSon().printStr();
  }

}
