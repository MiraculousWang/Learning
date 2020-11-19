package testNG;

import org.junit.Ignore;
import org.testng.annotations.Test;

@Ignore
public class testDependsOn {

  @Test(groups = { "init" })
  public void serverStartedOk() {}

  @Test(groups = { "init" })
  public void initEnvironment() {}

  @Test(dependsOnMethods = { "serverStartedOk" })
  public void method1() {}

  // dependsOnMethods，dependsOnGroups 都可以使用正则
  // alwaysRun 可以保证依赖的用例失败后，该用例还是会正常运行 而不是被SKIP
  @Test(dependsOnGroups = { "init.*" } ,alwaysRun = true)
  public void method2() {}

//  也可以在XML文件中对组依赖进行设置
//      <groups>
//        <dependencies>
//          <group name="c" depends-on="a  b" />
//          <group name="z" depends-on="c" />
//        </dependencies>
//      </groups>


}
