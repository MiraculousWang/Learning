package testNG.Listener;

import java.util.List;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

//  可以把结果写入数据库、或者写入xml、html或者EXCEL之类
//  自定义报告类型。写入数据库
//
public class MyReporterListener implements IReporter {

  @Override
  public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
      String outputDirectory) {

  }
}
