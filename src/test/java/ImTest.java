import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class ImTest extends  BaseTest {

   // public AppiumDriver driver;

    /**
     *
     * 聊天会话用例：
     * 1.点击首页的消息入口，进入消息聊天列表
     * 2.判断聊天会话列表是否有，有就进入聊天界面
     * 3.发送聊天内容：语音／文本消息／常用语／位置／收藏／相册／拍照
     * @auth 田瑞彩
     */
    @Test
    public void im()throws InterruptedException{

       // AndroidElement chatElement;
        Thread.sleep(20000);
        //点击消息，进入消息列表

        /**
         * MobileElement element=(MobileElement) driver.findElementsByName("消息");
         *         if(element.isDisplayed()){
         *             element.click();
         *             System.out.println("点击消息入口");
         *
         *         }else {
         *             System.out.println("无消息入口");
         *         }
         */


        driver.findElementByXPath("//*[@text='消息']").click();
      // driver.findElementByXPath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[0]/android.widget.RelativeLayout[contains(@index,0)]").click();

       // driver.findElementByXPath("//*[@text='田瑞彩']").click();
      // driver.findElementByXPath("//android.view.ViewGroup[1]／android.widget.LinearLayout[2]／android.widget.TextView[contains(@text,'田瑞彩')]").click();

       //driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.view.View/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]").click();
        String asserting=driver.getPageSource();

       /* if(asserting.contains("田瑞彩"))
            driver.findElementByName("田瑞彩").click();

*/
            try {

                driver.findElementByName("田瑞彩").click();

            }catch (Exception e){}



     //   driver.findElementById("com.wlqq.phantom.plugin.ymm.im:id/swipe_context").click();
        /**

        List<AndroidElement> ChatList =driver.findElement(By.id("com.wlqq.phantom.plugin.ymm.im:id/rv_message_list"));


        if (ChatList==null || ChatList.getSize()==0){
                   System.out.println("聊天列表为空");
                   driver.findElement(By.id("com.xiwei.logistics:id/btn_back"));

               }else {
                   for (AndroidElement  as :ChatList){
                       String chatlist=as.getAttribute("text");
                       System.out.println("ChatList:"+chatlist);
                       //聊天会话不为空
                       if(!chatlist.equals("")){
                           //点击聊天会话
                           driver.findElement(By.id("com.wlqq.phantom.plugin.ymm.im:id/swipe_context")).click();
                           Thread.sleep(1000);
                           //点击置顶货源按钮发送给对方
                           // driver.findElement(By.id("com.wlqq.phantom.plugin.ymm.im:id/send_tv")).click();
                           // driver.findElement(By.id("com.wlqq.phantom.plugin.ymm.im:id/et_sendmessage")).sendKeys("微信qq聊天发消息吧");
                           driver.findElement(By.id("com.wlqq.phantom.plugin.ymm.im:id/btn_common_words")).click();
                           driver.findElement(By.id("com.wlqq.phantom.plugin.ymm.im:id/tv_content")).click();


                       }

           }

        }*
         */

        System.out.println("im测试敬请期待！");


    }

}
