package testNG;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testDataProvide {
  // 提供数据 返回Object[][]
  @DataProvider(name = "Data")
  public Object[][] dataProvider_xxx(){
    return new Object[][]
        {
            {"蜘蛛侠",new Integer(1),true},
            {"猪猪侠",new Integer(2),true},
            {"钢铁侠",new Integer(3),true},
            {"蜻蜓侠",new Integer(5),false},
            {"蜻蜓侠",new Integer(6)},         //  参数数量不匹配时 异常TestNGException
        };
  }

  // 一个Iterator<Object[]> 。与Object[][]的唯一区别是，迭代器使您可以延迟创建测试数据。TestNG将依次调用迭代器，然后调用带有该迭代器返回的参数的测试方法。如果您有很多要传递给该方法的参数集而又不想预先创建所有参数集，则此功能特别有用。
  @DataProvider(name = "test1")
  public Iterator<Object[]> createData() {
//    return new MyIterator(DATA);
    return new ArrayList().iterator();
  }

  // 这样允许DataProvider 根据调用用例不同返回不同的测试数据。
  // 听上去好像可以同一个方法根据调用用例不同，对数据进行特殊化
  @DataProvider(name = "dp")
  public Object[][] createData(Method m) {
    System.out.println(m.getName());  // print test method name
    return new Object[][] { new Object[] { "Cedric" }};
  }

  // 接收数据 指定参数提供者为Data
  @Test(dataProvider = "Data")
  public void testParameters2(String name, int index, boolean hasView){
    System.out.println("Name : " + name + "   count : " + index + " hasView : " + hasView);
  }

  // 可以指定外部类内的静态无参方法作为 dataProvider, 外部类必须是public的.
  @Test(dataProvider = "Provider", dataProviderClass = StaticProvider.class)
  public void testParameters3(String name, int index, boolean hasView){
    System.out.println("Name : " + name + "   count : " + index + " hasView : " + hasView);
  }

}
