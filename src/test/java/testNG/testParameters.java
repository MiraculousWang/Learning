package testNG;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testParameters {

  // Parameters 可以在XML中设置值 可做全局变量使用。
  // Optional 如果未获取到parameters中的值，可以设置默认值
  @Parameters({"Parameter_Name", "Parameter_Count"})
  @Test
  public void testParameters(@Optional("默认名称") String name, @Optional("0") int count){
    System.out.println("Name : " + name + "   count : " + count);
  }

}
