import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
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
        //平台设置
        capabilities.setCapability("platformName","Android");
        //设备序列号设置
        capabilities.setCapability("deviceName","S9B7N17616001493");
        //系统版本号设置
        capabilities.setCapability("platformVersion","8.0.0");
        //capabilities.setCapability("deviceName","127.0.0.1:62001");
        //capabilities.setCapability("platformVersion","4.4.2");
        //支持中文输入
        capabilities.setCapability("unicodeKeyboard","true");
        //重置输入法到原有状态
        capabilities.setCapability("resetKeyboard","true");
        //capabilities.setCapability("app","app.getAbsolutePath()");
        //设置apk的包名
        capabilities.setCapability("appPackage","com.xiwei.logistics");
        //capabilities.setCapability("appActivity","com.xiwei.logistics.common.ui.WelcomeActivity");
        //设置启动Activity
        capabilities.setCapability("appActivity","com.xiwei.logistics.splash.SplashActivity");
        //session自动覆盖
        capabilities.setCapability("sessionOverride",false);
        //不需要再次安装
        capabilities.setCapability("noReset",false);
        //初始化
        driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        //等待20秒
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }

    @Test
    public void login() throws InterruptedException {

        //允许电话权限
        driver.findElementByXPath("//*[@text='始终允许']").click();
        //允许存储权限
        driver.findElementByXPath("//*[@text='始终允许']").click();
        //允许位置权限
        driver.findElementByXPath("//*[@text='始终允许']").click();
        //跳过首屏广告
       driver.findElement(By.id("com.xiwei.logistics:id/tv_skip")).click();
        //Thread.sleep(2000);
        //关闭弹框广告
        driver.findElement(By.id("com.xiwei.logistics:id/exit")).click();
        //点击登录
        driver.findElementByXPath("//*[@text='登录']").click();
        Thread.sleep(2000);
        //输入手机号码
        driver.findElementById("com.xiwei.logistics:id/mobile").sendKeys("13564229364");
       //点击获取短信验证
        driver.findElement(By.id("com.xiwei.logistics:id/btn_send_verify_code")).click();
       //允许权限
        driver.findElementByXPath("//*[@text='始终允许']").click();
        //输入验证码
       // Thread.sleep(2000);
        driver.findElement(By.id("com.xiwei.logistics:id/code_view")).sendKeys("9527");
        Thread.sleep(2000);
       //登录成功后进入首页-配货大厅，检查消息入口
        String message=driver.findElement(By.id("com.wlqq.phantom.plugin.ymm.cargo:id/tv")).getText();
        System.out.println(message);
        Assert.assertEquals("消息",message);
    }


    @AfterClass
    public  void tearDown(){

        driver.quit();

    }

}
