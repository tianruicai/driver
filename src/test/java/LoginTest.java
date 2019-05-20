import com.utils.DriverUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchContextException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import org.testng.annotations.Test;



public class LoginTest extends BaseTest{

   // public AppiumDriver driver=null;

    /**
     *登录用例：
     * 1.进入首页后跳过首屏广告,如果有广告关闭广告弹框
     * 2.点击登录-》输入手机号码-》点击获取短信验证码-》输入验证码-》自动登录成功
     * 3.检查首页消息入口是否存在
     *
     * @auto  田瑞彩
     */

    @Test
    public void login() throws InterruptedException {

        Thread.sleep(2000);
        //点击登录
       driver.findElementByXPath("//*[@text='登录']").click();
        //输入手机号码
        driver.findElementById("com.xiwei.logistics:id/mobile").sendKeys("13564229364");
       //点击获取短信验证
        driver.findElementById("com.xiwei.logistics:id/btn_send_verify_code").click();
        Thread.sleep(2000);
       // System.out.println("打印出当前页面的元素："+driver.getPageSource());

          //判断是否有允许权限弹框
        WebElement permisallb=driver.findElementById("com.android.packageinstaller:id/permission_allow_button");

                if(permisallb.isDisplayed()==true){
                      //允许权限

                    permisallb.click();

                  }else {
                      System.out.println("无权限弹框");
                  }

        Thread.sleep(2000);
        driver.findElementById("com.xiwei.logistics:id/edit_text_view").sendKeys("9527");
        Thread.sleep(2000);
       //登录成功后进入首页-配货大厅，检查消息入口
        String message=driver.findElementById("com.wlqq.phantom.plugin.ymm.cargo:id/tv").getText();
        System.out.println(message);
        Assert.assertEquals("消息",message);
    }



}
