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


class Test {
  private static Test instance;

  static {
    System.out.println("static开始");
    // 下面这句编译器报错，非法向前引用
    // System.out.println("x=" + x);
    instance = new Test();
    System.out.println("static结束");
  }

  public Test() {
    System.out.println("构造器开始");
    System.out.println("x=" + x + ";y=" + y);
    // 构造器可以访问声明于他们后面的静态变量
    // 因为静态变量在类加载的准备阶段就已经分配内存并初始化0值了
    // 此时 x=0，y=0
    x++;
    y++;
    System.out.println("x=" + x + ";y=" + y);
    System.out.println("构造器结束");
  }

  // 如果这一段在static代码块上面 构造器里的值就会变成6，0
  public static int x = 6;
  public static int y;

  public static Test getInstance() {
    return instance;
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
    Test obj = Test.getInstance();
    System.out.println("x=" + obj.x);
    System.out.println("y=" + obj.y);

    System.out.println("================== 分割线 ==================");
    new staticSon().printStr();
  }

}
