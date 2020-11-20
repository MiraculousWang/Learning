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


  // 修改方法在List<IMethodInstance>中的顺序来实现，用例执行顺序的控制
  // 示例修改的比较暴力，直接往第一个插入。
  // 用例多了的话，实现用例的合理顺序控制会有难度。毕竟在List里的其他方法的位置定位会比较困难
  // 感觉还是用group在XML中实现依赖会比较容易和方便

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
