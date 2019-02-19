import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class LoginTest {

    public AppiumDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        //capabilities.setCapability("deviceName","S9B7N17616001493");
        capabilities.setCapability("deviceName","127.0.0.1:62001");
        capabilities.setCapability("platformVersion","4.4.2");
        capabilities.setCapability("unicodeKeyboard","true");
        capabilities.setCapability("resetKeyboard","true");
        //capabilities.setCapability("app","app.getAbsolutePath()");
        capabilities.setCapability("appPackage","com.xiwei.logistics");
        //capabilities.setCapability("appActivity","com.xiwei.logistics.common.ui.WelcomeActivity");
        capabilities.setCapability("appActivity","com.xiwei.logistics.splash.SplashActivity");
        capabilities.setCapability("sessionOverride",true);
        capabilities.setCapability("noreset",true);
        driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }

    @Test
    public void login() throws InterruptedException {

        //Thread.sleep(3000);
        driver.findElementByClassName("android.widget.RelativeLayout").click();
        Thread.sleep(3000);
//       driver.findElementByName("消息").click();

        /*driver.findElementByClassName("android.widget.TextView").click();
        driver.findElementById("com.xiwei.logistics:id/iv_tab").click();
        driver.findElementByXPath("//*[@text='消息']").click();
        driver.findElementByXPath("//android.widget.TextView[contains(@text,'找货记录')]").click();
        driver.findElementByAccessibilityId("aa").click();
        driver.tap(1,0,76,0);*/

    }


    @AfterClass
    public  void tearDown(){
        driver.quit();
    }

}
