import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public AppiumDriver driver=null;

    //是否需要安装新包
    private  boolean isNeedInstall=true;

    @BeforeClass
    public void setUp() throws MalformedURLException {


        //设置自动化相关参数
        DesiredCapabilities capabilities=new DesiredCapabilities();
        //平台设置
        capabilities.setCapability("platformName","Android");

        //设备序列号设置
        capabilities.setCapability("deviceName","S9B7N17616001493");
        //系统版本号设置
        capabilities.setCapability("platformVersion","8.0.0");
        /**
         * capabilities.setCapability("deviceName","127.0.0.1:62001");
         * capabilities.setCapability("platformVersion","4.4.2");
         */

        //支持中文输入
        capabilities.setCapability("unicodeKeyboard","True");
        //重置输入法到原有状态
        capabilities.setCapability("resetKeyboard","True");
        //apk安装

        File classpathRoot = new File(System.getProperty("user.dir"));

        System.out.println("项目路径："+classpathRoot);
        //app的目录
        File appDir = new File(classpathRoot, "src/main/java/apps");
        File app = new File(appDir, "DRIVER.apk");

        // isNeedInstall为true时，appium需要解析本地的apk包来得到包名和mainActivity

        if (app.exists()&&isNeedInstall){

            System.out.println("安装包是否存在："+app.exists());
            //apk安装司机端
            capabilities.setCapability("app",app.getAbsolutePath());

            //capabilities.setCapability(MobileCapabilityType.APP,"src/main/java／apps／DRIVER.apk");

        }else {
            //isNeedInstall为false时，不需要解析apk直接通过appPackage和appActivity在手机查找启动app
            //设置apk的包名
            capabilities.setCapability("appPackage","com.xiwei.logistics");
            //设置启动Activity
            capabilities.setCapability("appActivity","com.xiwei.logistics.splash.SplashActivity");

        }

        //session自动覆盖
        capabilities.setCapability("sessionOverride",false);
        //安装时是否对apk进行重签名，为true不进行重新签名
        capabilities.setCapability("noSign",true);
        //不需要再次安装
        capabilities.setCapability("noReset",true);
        //设置session的超时时间
       // capabilities.setCapability("newCommandTimeout",600);
        //等待设备就绪的时间
        //capabilities.setCapability("deviceReadyTimeout",600);
        try{
            //初始化
            driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }


        //等待20秒
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }



    @AfterClass
    public  void tearDown(){

        try {

            Thread.sleep(15000);

        }catch (InterruptedException e){

            e.printStackTrace();

        }finally {
            if (driver!=null){

                driver.quit();

            }
        }


    }




}
