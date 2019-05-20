package com.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.logging.Logger;

public class DriverUtil {
    /**
     * 持续点击控件
     *
     * @param driver
     * @param by
     */

  public static  void keepClickElement(AppiumDriver driver, By by){

      try {
          WebElement element = driver.findElement(by);
         while (true){
             if(element.isDisplayed()){
                 element.click();
             }else {
                 break;
             }
         }
      }catch (NoSuchElementException e){
         // Logger.debug("未找到该控件"+by);
          System.out.println("未找到该控件"+by);

      }
  }

    /**
     * 出现阻塞步骤的系统弹窗时，accept 继续
     *
     * @param driver
     */
    public  static  void acceptPermission(AppiumDriver driver) {

        keepClickElement(driver, new MobileBy.ByAndroidUIAutomator("new UiSelector().className(\"android.widget.Button\").textMatches(\".*始终允许.*\")"));


    }


}
