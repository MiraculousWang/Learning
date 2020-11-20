package testNG.Listener;

import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

// 不知道咋用，看上去用起来应该挺复杂的。功能感觉可以用其他监听器实现

// 此监听器中的run方法被调用并替代所有被@Test注解标识的方法来运行
// 和@Configuration注解一起使用

public class MyIHookableListener implements IHookable {

  @Override
  public void run(IHookCallBack callBack, ITestResult testResult) {

  }
}
