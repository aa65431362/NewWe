package activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import base.BaseActivity;
import team.newwe.holmes.holmesdemo.R;

/**
 * Created by yaochen on 2016/11/29.
 */

public class TestActivity extends BaseActivity implements View.OnClickListener {

    private Button circleImgViewBtn;

    @Override
    protected int getContentLayout() {
        return R.layout.activity_test;
    }

    @Override
    protected void initGui() {
        circleImgViewBtn = (Button) findViewById(R.id.circleImageView);
    }

    @Override
    protected void initAction() {
        circleImgViewBtn.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.circleImageView:
                gotoActivity(CircleImageViewActivity.class);
                break;
            default:
                break;
        }
    }

    private void gotoActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }
}
