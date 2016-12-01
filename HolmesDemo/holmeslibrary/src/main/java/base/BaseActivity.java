package base;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by yaochen on 2016/11/29.
 */

public abstract class BaseActivity extends Activity {

    protected Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 取消标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        activity = this;
        // 添加到activity stack管理集合
        ActivityStack.getInstance().addActivity(this);
        if (0 != getContentLayout()) {
            setContentView(getContentLayout());
        }
        initGui();
        initData();
        initAction();
    }

    /**
     * 获取布局文件ID
     *
     * @return 布局文件ID
     */
    protected abstract int getContentLayout();

    /**
     * 初始化控件
     */
    protected abstract void initGui();

    /**
     * 初始化事件
     */
    protected abstract void initAction();

    /**
     * 初始化页面数据
     */
    protected abstract void initData();

    /**
     * 退出activity,stack中删除activity
     */
    @Override
    protected void onDestroy() {
        // 删除集合存储记录
        ActivityStack.getInstance().removeActivity(this);
        super.onDestroy();
        System.gc();
    }
}
