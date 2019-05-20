import com.utils.DriverUtil;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class InitTest extends BaseTest {

    /**
     *1.同意用户协议
     *2.允许权限
     *3.跳过首屏广告
     *4.关闭弹框广告
     * @auto  田瑞彩
     */

    @Test
    public  void init() throws InterruptedException {

         //同意用户授权协议
        driver.findElementById("com.xiwei.logistics:id/dialog_btn_right").click();


       //去授权
        WebElement agreebtn=driver.findElementById("com.xiwei.logistics:id/btn_agree");

        if(agreebtn.isDisplayed()){

            agreebtn.click();

        }else{
            System.out.println("无授权");

        }


        //始终允许权限
       // DriverUtil.acceptPermission(driver);
        driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
        driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
        driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();

        //跳过首屏广告
        driver.findElementByXPath("//*[@text='跳过']").click();
        //关闭弹框广告
        WebElement element =driver.findElementById("com.xiwei.logistics:id/exit");

        if(element.isDisplayed()==true){
            element.click();
        }else {
            System.out.println("无弹框广告");
        }


    }

}
