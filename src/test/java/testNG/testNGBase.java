package testNG;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class testNGBase {

  @BeforeSuite
  public void beforeSuite(){

  }

  @BeforeClass
  public void beforeClass(){
    System.out.println("testNGBase : beforeClass");
  }

  @BeforeMethod
  public void beforeMethod(){

  }


  @Test(description = "testLinuxOnly")
  public void testLinuxOnly() {
    System.out.println("testLinuxOnly");
  }

  // threadPoolSize 线程池大小
  // invocationCount 总共运行多少次
  // timeOut 线程执行10秒后, 判定超时自动退出
  @Test(threadPoolSize = 3, invocationCount = 10,  timeOut = 10000)
  public void testThread(){
    System.out.println("testThread");
  }

  @Test(retryAnalyzer = MyRetry.class)
  public void testRetryListeners() {
    System.out.println("testLinuxOnly");
  }

  @AfterMethod
  public void afterMethod(){

  }

  @AfterClass
  public void afterClass(){

  }

  @AfterSuite
  public void afterSuite(){

  }
}
