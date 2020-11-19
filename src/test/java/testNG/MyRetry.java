package testNG;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


// 设置监听器，可以在监听器内进行监听，进行特色化处理。
// 比如可以记录成功失败用例，输出到log中。
// 可以判断用例执行状态，重试用例

// 在XML文件中添加监听器。或者可以直接在test注解上指定监听器
public class MyRetry implements IRetryAnalyzer {

  private int retryCount = 0;
  private static final int maxRetryCount = 3;

  @Override
  public boolean retry(ITestResult result) {
    if (retryCount < maxRetryCount) {
      retryCount++;
      return true;
    }
    return false;
  }
}

