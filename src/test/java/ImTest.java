import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 *
 * 聊天会话用例：
 * 1.聊天界面元素校验
 * 2.聊天设置
 * 3.常用语:添加，删除，发送
 * 4.发送语音
 * 5.发送文本
 * 6.发送位置
 * 7.发送收藏
 * 8.发送图片
 * 9.拍照上传
 * 10.拍摄视频上传
 * @auth 田瑞彩
 */
public class ImTest extends BaseTest {

    /**
     * 聊天界面元素校验
     * 1.进入消息聊天列表，进入聊天会话"田瑞彩"
     * 2.检查拨打电话元素
     * 3.检查用户角色和用户名
     */

    @Test(priority = 0)
    public void im()throws InterruptedException{

       // AndroidElement chatElement;
        Thread.sleep(20000);
        //点击消息，进入消息列表
        driver.findElementByXPath("//*[@text='消息']").click();
        //点击聊天会话"田瑞彩"，进入聊天界面
        driver.findElementByXPath("//*[@text='田瑞彩']").click();
        driver.findElementById("com.wlqq.phantom.plugin.ymm.im:id/iv_call").isDisplayed();
        String imname=driver.findElementById("com.wlqq.phantom.plugin.ymm.im:id/tv_name").getText();
        Assert.assertEquals("货主田瑞彩",imname);

    }
    /**
     * 聊天设置
     * 1.进入聊天设置
     * 2.清空聊天记录；
     * 3.跳转到意见反馈页面;
     */
    @Test(priority = 1)
     public void imsetting(){
        //进入聊天设置界面
        driver.findElementById("com.wlqq.phantom.plugin.ymm.im:id/iv_setting").click();
        //查看屏蔽此人聊天
        String compat=driver.findElementById("com.wlqq.phantom.plugin.ymm.im:id/switch_compat").getText();
        Assert.assertEquals("关闭",compat);
        //点击"清空聊天记录"
        driver.findElementById("com.wlqq.phantom.plugin.ymm.im:id/rl_clear_history").click();
        //确认界面点击"清空"
        driver.findElementById("com.wlqq.phantom.plugin.ymm.im:id/text_positive").click();
        //点击意见反馈
        driver.findElementById("com.wlqq.phantom.plugin.ymm.im:id/rl_feedback").click();
        //点击返回，返回到聊天设置
        driver.findElementById("com.xiwei.logistics:id/iv_left").click();
        //点击返回，返回到聊天界面
        driver.findElementById("com.wlqq.phantom.plugin.ymm.im:id/iv_back").click();

    }

      /**
        *常用语
        * 1.添加常用语
        * 2.编辑删除常用语
        * 3.发送常用语
      */
    @Test(priority = 2)
    public void commonword(){

        //展开常用语
        driver.findElementById("com.wlqq.phantom.plugin.ymm.im:id/btn_common_words").click();
        //添加常用语
        driver.findElementById("com.wlqq.phantom.plugin.ymm.im:id/tv_add").click();
        //输入常用语
        driver.findElementById("com.wlqq.phantom.plugin.ymm.im:id/input_common_word").sendKeys("田瑞彩");
        //点击"确定添加"
        driver.findElementById("com.wlqq.phantom.plugin.ymm.im:id/text_positive").click();
        //点击编辑，点击删除
        driver.findElementById("com.wlqq.phantom.plugin.ymm.im:id/tv_edit").click();
        driver.findElementById("com.wlqq.phantom.plugin.ymm.im:id/iv_delete").click();
        //发送常用语
        driver.findElementById("com.wlqq.phantom.plugin.ymm.im:id/tv_edit").click();
        driver.findElementById("com.wlqq.phantom.plugin.ymm.im:id/tv_content").click();
    }
        /**
          * 发送语音
          *录制语音并发送
          *
         */
    @Test(priority = 3)
    public  void voice(){
        driver.findElementById("com.wlqq.phantom.plugin.ymm.im:id/btn_set_mode_voice").click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElementById("com.wlqq.phantom.plugin.ymm.im:id/btn_voice_send").click();
    }

    /**
     * 发送文本
     * 输入文本并发送
     */

    @Test(priority = 4)
    public void sendmessage(){

        driver.findElementById("com.wlqq.phantom.plugin.ymm.im:id/et_sendmessage").sendKeys("输入文本测试发送文本微信，有问题请拨打手机号13564229364");
        driver.findElementById("com.wlqq.phantom.plugin.ymm.im:id/btn_send").click();
    }

    /**
     *发送位置
     * 定位当前位置并发送
     */
    @Test(priority = 5)
  public void position(){
        driver.findElementById("com.wlqq.phantom.plugin.ymm.im:id/btn_more").click();
        driver.findElementByXPath("//*[@text='位置']").click();
        driver.findElementById("com.wlqq.phantom.plugin.amap:id/tv_select_loc_send").click();

    }
/**
 * 发送收藏
 *
 */
    @Test(priority = 6)
    public void Collection(){
        driver.findElementById("com.wlqq.phantom.plugin.ymm.im:id/btn_more").click();
        driver.findElementByXPath("//*[@text='收藏']").click();
        driver.findElementByXPath("//*[@class='android.widget.LinearLayout']").click();
        driver.findElementById("com.wlqq.phantom.plugin.ymm.im:id/confirm").click();
    }
    /**
     * 发送图片
     * 选择图片并发送
     */
    @Test(priority = 7)
   public void picture(){
        driver.findElementById("com.wlqq.phantom.plugin.ymm.im:id/btn_more").click();
        driver.findElementByXPath("//*[@text='图片']").click();
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[3]/android.widget.ImageView[2]").click();
        //driver.findElementById("com.xiwei.logistics.consignor:id/image_select").click();
        driver.findElementById("com.xiwei.logistics:id/btn_confirm").click();

   }
    /**
     * 拍照上传
     * 拍照发送图片
     */
    @Test(priority = 8)
    public void Photograph(){
        driver.findElementById("com.wlqq.phantom.plugin.ymm.im:id/btn_more").click();
        driver.findElementByXPath("//*[@text='拍摄']").click();
        driver.findElementById("com.huawei.camera:id/shutter_button").click();
        driver.findElementById("com.huawei.camera:id/done_button").click();

    }
    /**
     * 拍摄视频
     * 拍摄视频并发送
     */
    @Test(priority = 9)
    public void video() throws InterruptedException {
        driver.findElementById("com.wlqq.phantom.plugin.ymm.im:id/btn_more").click();
        driver.findElementByXPath("//*[@text='视频']").click();
        TouchAction action=new TouchAction(driver);
        // 长按
        action.longPress( driver.findElementByClassName("android.view.View"),10000).release().perform();
        driver.findElementById("com.xiwei.logistics:id/icon_done").click();

    }

}
