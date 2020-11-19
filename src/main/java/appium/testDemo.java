package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class testDemo {

  private AndroidDriver driver;

  @Before
  public void setUp() throws MalformedURLException {
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability("platformName", "android");
    desiredCapabilities.setCapability("ensureWebviewsHavePages", true);

    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
  }

  @Test
  public void sampleTest() {
    MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[9]/android.widget.FrameLayout/android.widget.ImageView");
    el1.click();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    MobileElement el2 = (MobileElement) driver.findElementById("pro.huobi:id/search_symbol_input");
    el2.click();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    MobileElement el3 = (MobileElement) driver.findElementById("pro.huobi:id/search_symbol_input");
    el3.sendKeys("SUN");
    MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]");
    el4.click();
  }

  @After
  public void tearDown() {
    driver.quit();
  }
}
