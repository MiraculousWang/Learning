package testNG;

import org.testng.annotations.DataProvider;


public class StaticProvider {

  // DataProvider可以不指定name，这样默认的name为方法名dataProvider_NoName
  @DataProvider
  public static Object[][] dataProvider_NoName(){
    return new Object[][]
        {
            {"蜘蛛侠",new Integer(1),true},
            {"猪猪侠",new Integer(2),true},
            {"钢铁侠",new Integer(3),true},
            {"蜻蜓侠",new Integer(5),false},
            {"蜻蜓侠",new Integer(6),}        //  参数数量不匹配时 异常TestNGException
        };
  }

  @DataProvider(name = "Provider")
  public static Object[][] dataProvider_name(){
    return new Object[][]
        {
            {"蜘蛛侠",new Integer(1),true},
            {"猪猪侠",new Integer(2),true},
            {"钢铁侠",new Integer(3),true},
            {"蜻蜓侠",new Integer(5),false},
            {"蜻蜓侠",new Integer(6)}        //  参数数量不匹配时 异常TestNGException
        };
  }
}
