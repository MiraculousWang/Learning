package testNG;

import org.testng.TestNG;
import org.testng.annotations.Factory;

public class testFactory {
  @Factory
  public Object[] createInstances() {
    Object[] result = new Object[10];
    for (int i = 0; i < 10; i++) {
      result[i] = new testGroups(i * 10);
    }
    return result;
  }

  public static void main(String[] args){
    TestNG t = new TestNG();
    t.setTestClasses(new Class[]{testFactory.class});
    t.run();
  }
}
