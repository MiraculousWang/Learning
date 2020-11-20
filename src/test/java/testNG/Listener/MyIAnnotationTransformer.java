package testNG.Listener;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import org.testng.IAnnotationTransformer;
import org.testng.IAnnotationTransformer2;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.IConfigurationAnnotation;
import org.testng.annotations.IDataProviderAnnotation;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.ITestAnnotation;
import testNG.MyRetry;



// 强大的配置 可以
public class MyIAnnotationTransformer implements IAnnotationTransformer, IAnnotationTransformer2{

  // IAnnotationTransformer2
  @Override
  public void transform(IConfigurationAnnotation annotation, Class testClass,
      Constructor testConstructor, Method testMethod) {

  }

  // IAnnotationTransformer2
  @Override
  public void transform(IDataProviderAnnotation annotation, Method method) {
    // 可以获取参数类型，设置DataProvider参数。有点厉害

    Annotation[][] getParameterAnnotations = method.getParameterAnnotations();
    Class<?>[] getParameterTypes = method.getParameterTypes();
    TypeVariable<Method>[] getTypeParameters = method.getTypeParameters();
    int getParameterCount = method.getParameterCount();

    annotation.setName("DataProvideer");

  }

  // IAnnotationTransformer2
  @Override
  public void transform(IFactoryAnnotation annotation, Method method) {

  }


  // IAnnotationTransformer1
  @Override
  public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor,
      Method testMethod) {

    annotation.setAlwaysRun(true);
    testClass.isAnnotation();
    testConstructor.getName();
    testMethod.getName();


    // 实际用到的。
    // 在XML中添加这个Listener。就可以全局设置重试，因为重试IRetryAnalyzer只能在Test注解中使用。
    IRetryAnalyzer retry = annotation.getRetryAnalyzer();
    if (retry == null){
      annotation.setRetryAnalyzer(MyRetry.class);
    }



    // 设置  根据名称和参数类型设置数据源

    if (testMethod.getName().equals("testParameters2")){
      annotation.setDataProvider("Data");
    }

    int getParameterCount = testMethod.getParameterCount();
    Class<?>[] getParameterTypes = testMethod.getParameterTypes();

    if(getParameterCount == 3 && getParameterTypes.length == 3){
      if (getParameterTypes[0].equals(String.class) &&
          getParameterTypes[1].equals(Integer.class) &&
          getParameterTypes[2].equals(Boolean.class))
      {
        annotation.setDataProvider("Data");
      }
    }
  }
}
