package activity;

import base.BaseActivity;
import team.newwe.holmes.holmesdemo.R;
import view.CircleImageView;

/**
 * Created by Administrator on 2016/11/29.
 */

public class CircleImageViewActivity extends BaseActivity {

    private CircleImageView circleImageView;

    @Override
    protected int getContentLayout() {
        return R.layout.activity_circleimgview;
    }

    @Override
    protected void initGui() {
        circleImageView = (CircleImageView) findViewById(R.id.circleImageView);
    }

    @Override
    protected void initAction() {

    }

    @Override
    protected void initData() {

    }
}
