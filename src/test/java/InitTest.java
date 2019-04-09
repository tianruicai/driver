import com.utils.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class InitTest extends BaseTest {

    /**
     *系统弹框允许权限
     *
     *
     *
     * @auto  田瑞彩
     */

    @Test
    public  void init(){



       //关闭系统弹框
        DriverUtil.acceptPermission(driver);
       //跳过首屏广告
        driver.findElement(By.id("com.xiwei.logistics:id/tv_skip")).click();
        //关闭弹框广告

        WebElement element=driver.findElement(By.id("com.xiwei.logistics:id/exit"));

        if(element.isDisplayed()){
            element.click();
        }else {
            System.out.println("无弹框广告");
        }


    }

}
