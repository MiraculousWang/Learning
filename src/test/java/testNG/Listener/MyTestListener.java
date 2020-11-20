package testNG.Listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


//  对测试用例做一些特色化处理， 功能好像挺强大的
//  可以用下级的一些实现类
//
//  一类是测试用例级别的
//      例如onTestStart，onTestSuccess，onTestFailure，onTestSkipped，onTestFailedButWithinSuccessPercentage；
//  另一类是测试集级别的
//      例如onStart，onFinish。这些方法有一个输入参数，result或者context。result是ITestResult类型的，可以知晓测试用例成功或者失败和测试何时开始等信息。context是ITestContext类型的，适用于测试集级别，可以知晓成功的脚本有哪些，失败的脚本有哪些。

public class MyTestListener implements ITestListener {

  @Override
  public void onTestStart(ITestResult result) {

  }

  @Override
  public void onTestSuccess(ITestResult result) {

  }

  @Override
  public void onTestFailure(ITestResult result) {

  }

  @Override
  public void onTestSkipped(ITestResult result) {

  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

  }

  @Override
  public void onStart(ITestContext context) {

  }

  @Override
  public void onFinish(ITestContext context) {

  }
}
