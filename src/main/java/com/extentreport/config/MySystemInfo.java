
package com.extentreport.config;
import com.vimalselvam.testng.SystemInfo;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Auther: tianruicai
 * @Date:2019/3/1
 * @Description:
 */
public class MySystemInfo implements SystemInfo {

    @Override
    public Map<String, String> getSystemInfo() {

        Map<String, String> systemInfo = new HashMap<>();
        systemInfo.put("环境", "线上");
        systemInfo.put("app类型", "司机端");
        systemInfo.put("平台", "android");
        systemInfo.put("版本号", "6.14.0.0");
        systemInfo.put("测试执行人", "田瑞彩");
        return systemInfo;
    }
}
