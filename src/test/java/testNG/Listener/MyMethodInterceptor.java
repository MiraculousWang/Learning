package testNG.Listener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.annotations.Test;

// 自定义用例依赖和执行顺序
//顺序执行的方法，即依赖于其他测试方法或者被其他测试方法所依赖
//执行无特定顺序的方法，即测试方法的执行没有特定的顺序要求，不同的TestNG执行可能有不同的顺序。

public class MyMethodInterceptor implements IMethodInterceptor {

  @Override
  public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
    List<IMethodInstance> result = new ArrayList<IMethodInstance>();
    for (IMethodInstance m : methods)
    {
      Test test = m.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class);
      Set<String> groups = new HashSet<String>();
      for (String group : test.groups())
      {
        groups.add(group);
      }
      if (groups.contains("dependGroup1"))
      {
        result.add(0, m);
      }
      else {
        result.add(m);
      }
    }
    return result;
  }
}
