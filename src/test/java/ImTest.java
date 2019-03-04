import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ImTest {

    public AppiumDriver driver;


    @Test
    public void im()throws InterruptedException{

        //点击消息，进入消息列表
        driver.findElement(By.id("com.wlqq.phantom.plugin.ymm.cargo:id/tv")).click();

        System.out.println("im测试敬请期待！");


    }

}
