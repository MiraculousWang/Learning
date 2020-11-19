package testNG;

import org.testng.annotations.Test;

// class 上加了test可以作用到下面的函数
// class 中的group可以作用到类中所有的方法
@Test(groups = { "all" })
public class testGroups {

  private int FactoryId;
  public testGroups(int factoryId){
    this.FactoryId = factoryId;
  }

  // groups = { "windows.checkintest" , "all"}
  @Test(groups = { "windows.checkintest" })
  public void testWindowsOnly() {
    System.out.println("testWindowsOnly");
  }

  @Test(groups = {"linux.checkintest"} )
  public void testLinuxOnly() {
    System.out.println("testLinuxOnly");
  }

  @Test(groups = { "windows.functest" })
  public void testWindowsToo() {
    System.out.println("testWindowsToo");
  }

}