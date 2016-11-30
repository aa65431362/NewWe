package base;

import android.app.Application;
import android.content.Context;

/**
 * Created by yaochen on 2016/11/29.
 */

public class BaseApplication extends Application {

    /**
     * 全局上下文对象
     */
    private Context mContext;

    /**
     * 全局BaseApplication唯一实例
     */
    private static BaseApplication instance;

    /**
     * 全局APP标识名称
     */
    private String appName;

    /**
     * 全局屏幕宽度
     */
    private int mDiaplayWidth;

    /**
     * 全局屏幕高度
     */
    private int mDiaplayHeight;

    /**
     *
     * @return 获取上下文对象
     */
    public Context getContext() {
        if (mContext == null) {
            mContext = this;
        }
        return mContext;
    }

    /**
     * 设置上下文对象
     *
     * @param mContext
     */
    public void setContext(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * 获取一个LApplication的实例
     *
     * @return
     */
    public static synchronized BaseApplication getInstance() {
        if (instance == null) {
            instance = new BaseApplication();
        }
        return instance;
    }

    /**
     * 设置一个BaseApplication的实例
     *
     * @param app
     */
    public static void setInstance(BaseApplication app) {
        instance = app;
    }

    /**
     * 获取应用标识名称
     *
     * @return
     */
    public String getAppName() {
        return appName;
    }

    /**
     * 设置应用标识名称
     *
     * @param appName
     */
    public void setAppName(String appName) {
        this.appName = appName;
    }
}
