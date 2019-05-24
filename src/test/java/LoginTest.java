import com.utils.DriverUtil;

import org.testng.Assert;

import org.testng.annotations.Test;



public class LoginTest extends BaseTest{


    /**
     *1.同意用户协议
     *2.允许权限：电话权限／存储权限／位置权限
     *3.跳过首屏广告
     *4.关闭弹框广告
     * @auto  田瑞彩
     */
    @Test(priority = 1)
    public void init()throws InterruptedException{

        //同意用户授权协议
        driver.findElementById("com.xiwei.logistics:id/dialog_btn_right").click();
        //去授权，始终允许权限

        for(int i=0;i<4;i++){
            DriverUtil.permission(driver);
            System.out.println("i的值是："+i);
        }
        Thread.sleep(2000);
        //跳过首屏广告
        driver.findElementById("com.xiwei.logistics:id/tv_skip").click();
        //关闭弹框广告

        if(driver.findElementById("com.xiwei.logistics:id/exit").isDisplayed()==true){
            driver.findElementById("com.xiwei.logistics:id/exit").click();
        }else {

            System.out.println("无弹框广告");
        }


    }


    /**
     *登录用例：
     * 1.进入首页后跳过首屏广告,如果有广告关闭广告弹框
     * 2.点击登录-》输入手机号码-》点击获取短信验证码-》输入验证码-》自动登录成功
     * 3.检查首页消息入口是否存在
     *
     * @auto  田瑞彩
     */

    @Test(priority = 2)
    public void login() throws InterruptedException {


        Thread.sleep(2000);
        //点击登录
       driver.findElementByXPath("//*[@text='登录']").click();
        //输入手机号码
        driver.findElementById("com.xiwei.logistics:id/mobile").sendKeys("13564229364");
       //点击获取短信验证
        driver.findElementById("com.xiwei.logistics:id/btn_send_verify_code").click();
        //判断是否有允许权限弹框
        DriverUtil.permission(driver);
        Thread.sleep(4000);
        driver.findElementById("com.xiwei.logistics:id/edit_text_view").sendKeys("9527");
        Thread.sleep(2000);
        //登录成功后进入首页-配货大厅，检查消息入口
        String message=driver.findElementById("com.wlqq.phantom.plugin.ymm.cargo:id/tv").getText();
        System.out.println(message);
        Assert.assertEquals("消息",message);
    }



}
