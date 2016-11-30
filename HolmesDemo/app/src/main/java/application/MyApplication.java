package application;

import base.BaseApplication;

/**
 * Created by yaochen on 2016/11/29.
 */

public class MyApplication extends BaseApplication {

    private static final String TAG = "MyApplication";

    public static String uuid; // 设备uuid

    private static MyApplication mApp;
    private String app_version;// 应用版本号
    private String IMEI;// 设备IMEI
    private String systemInfo;// 系统版本信息
    private String deviceBrand;// 设备品牌
    private String deviceModel;// 设备型号
    private int sdkInfo;// SDK版本信息

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        mApp = this;
    }

    public static MyApplication getInstance() {
        return mApp;
    }
}
