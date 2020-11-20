package testNG.Listener;

import org.testng.ISuite;
import org.testng.ISuiteListener;


// 可以在测试套件开始前和结束后
// 环境的重置、进行一些记录、自定义输出报告

public class MySuiteListener implements ISuiteListener {

  @Override
  public void onStart(ISuite suite) {

  }

  @Override
  public void onFinish(ISuite suite) {

  }
}

