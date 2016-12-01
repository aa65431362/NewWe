package activity;

import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import base.BaseActivity;
import bean.ElevatorBean;
import team.newwe.holmes.holmesdemo.R;
import view.Elevator;

/**
 * Created by Administrator on 2016/11/30.
 */

public class ElevatorActivity extends BaseActivity {

    private Elevator elevator;

    private List<ElevatorBean> itemList;

    private ScrollView scrollView;

    private LinearLayout viewContainer;

    @Override
    protected int getContentLayout() {
        return R.layout.activity_elevator;
    }

    @Override
    protected void initGui() {
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        viewContainer = (LinearLayout) findViewById(R.id.viewContainer);
        elevator = (Elevator) findViewById(R.id.elevator);
    }

    @Override
    protected void initAction() {

        elevator.setList(itemList);
        elevator.setElevatorOnClickListener(new Elevator.ElevatorOnClicklistener() {
            @Override
            public void OnClick(ElevatorBean item) {
                Toast.makeText(getApplicationContext(), item.getName() + " " + item.getId(), Toast.LENGTH_SHORT).show();
                int scrollHeight = 0;
                for (int i = 0; i < itemList.indexOf(item); i++) {
                    scrollHeight += itemList.get(i).getViewHeight();
                }
                viewContainer.scrollTo(0, scrollHeight);
            }
        });
    }

    @Override
    protected void initData() {

        itemList = new ArrayList<ElevatorBean>();
        ElevatorBean item1 = new ElevatorBean("母婴");
        itemList.add(item1);
        ElevatorBean item2 = new ElevatorBean("体育");
        itemList.add(item2);
        ElevatorBean item3 = new ElevatorBean("海外");
        itemList.add(item3);
        ElevatorBean item4 = new ElevatorBean("衣服");
        itemList.add(item4);
        ElevatorBean item5 = new ElevatorBean("电子");
        itemList.add(item5);
        ElevatorBean item6 = new ElevatorBean("生鲜");
        itemList.add(item6);
        ElevatorBean item7 = new ElevatorBean("电竞");
        itemList.add(item7);
        ElevatorBean item8 = new ElevatorBean("动漫");
        itemList.add(item8);
        ElevatorBean item9 = new ElevatorBean("奢侈品");
        itemList.add(item9);
        ElevatorBean item10 = new ElevatorBean("品牌");
        itemList.add(item10);
        ElevatorBean item11 = new ElevatorBean("拍卖");
        itemList.add(item11);
        ElevatorBean item12 = new ElevatorBean("众筹");
        itemList.add(item12);

        // 测量宽高
        int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        for (ElevatorBean currentItem : itemList) {

            TextView textView = new TextView(this);
            textView.setText(currentItem.getName());
//    		textView.setTextSize(50);
            textView.setGravity(Gravity.CENTER);
            textView.measure(w, h);
            currentItem.setViewHeight(textView.getMeasuredHeight());
            viewContainer.addView(textView);
        }
    }
}
