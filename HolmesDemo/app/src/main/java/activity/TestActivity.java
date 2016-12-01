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

    private Button circleImgViewBtn, dragPointBtn, elevatorBtn;

    @Override
    protected int getContentLayout() {
        return R.layout.activity_test;
    }

    @Override
    protected void initGui() {
        circleImgViewBtn = (Button) findViewById(R.id.btn_circleImageView);
        dragPointBtn = (Button) findViewById(R.id.btn_dragpoint);
        elevatorBtn = (Button) findViewById(R.id.btn_elevator);
    }

    @Override
    protected void initAction() {
        circleImgViewBtn.setOnClickListener(this);
        dragPointBtn.setOnClickListener(this);
        elevatorBtn.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_circleImageView:
                gotoActivity(CircleImageViewActivity.class);
                break;
            case R.id.btn_dragpoint:
                gotoActivity(DragPointActivity.class);
                break;
            case R.id.btn_elevator:
                gotoActivity(ElevatorActivity.class);
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
