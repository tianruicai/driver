import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchContextException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import org.testng.annotations.Test;




public class LoginTest extends BaseTest {

    /**
     *登录用例：
     * 1.进入首页后跳过首屏广告,如果有广告关闭广告弹框
     * 2.点击登录-》输入手机号码-》点击获取短信验证码-》输入验证码-》自动登录成功
     * 3.检查首页消息入口是否存在
     *
     * @auto  田瑞彩
     */

    @Test
    public void login() throws Exception {


        /**
         * //允许电话权限
         *         //driver.findElementByXPath("//*[@text='始终允许']").click();
         *         //允许存储权限
         *         //driver.findElementByXPath("//*[@text='始终允许']").click();
         *         //允许位置权限
         *         //driver.findElementByXPath("//*[@text='始终允许']").click();
         *         //跳过首屏广告
         *        // driver.findElement(By.id("com.xiwei.logistics:id/tv_skip")).click();
         *         //Thread.sleep(2000);
         * //关闭弹框广告
         *         WebElement element=driver.findElement(By.id("com.xiwei.logistics:id/exit"));
         *
         *         if(element.isDisplayed()){
         *             element.click();
         *         }else {
         *             System.out.println("无弹框广告");
         *         }
         */



        //点击登录

        driver.findElementByXPath("//*[@text='登录']").click();
        Thread.sleep(2000);
        //输入手机号码
        driver.findElementById("com.xiwei.logistics:id/mobile").sendKeys("13564229364");
       //点击获取短信验证
        driver.findElement(By.id("com.xiwei.logistics:id/btn_send_verify_code")).click();

        /**
         * //判断是否有允许权限弹框
         *        MobileElement element=(MobileElement) driver.findElementByXPath("//*[@text='始终允许']");
         *         if(element.isDisplayed()){
         *             //允许权限
         *             element.click();
         *         }else {
         *             System.out.println("无权限弹框");
         *
         *         }
         */
        String asserting=driver.getPageSource();

        if(asserting.contains("始终允许")){

            driver.findElementByXPath("//*[@text='始终允许']").click();

           /* try{

                driver.findElementByXPath("//*[@text='始终允许']").click();

            }catch (Exception e){
                e.printStackTrace();
            }*/
        }

       // Thread.sleep(2000);
        //输入验证码
        driver.findElement(By.id("com.xiwei.logistics:id/code_view")).sendKeys("9527");
        Thread.sleep(2000);
       //登录成功后进入首页-配货大厅，检查消息入口
        String message=driver.findElement(By.id("com.wlqq.phantom.plugin.ymm.cargo:id/tv")).getText();
        System.out.println(message);
        Assert.assertEquals("消息",message);
    }



}
