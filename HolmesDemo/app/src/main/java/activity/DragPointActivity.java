package activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import adapter.DragPointAdapter;
import base.BaseActivity;
import bean.DragPointBean;
import team.newwe.holmes.holmesdemo.R;

/**
 * Created by yaochen on 2016/11/30.
 * 仿QQ聊天拖拽消息气泡
 */

public class DragPointActivity extends BaseActivity {

    private RecyclerView recyclerView;

    private List<DragPointBean> list = new ArrayList<>();
    private DragPointAdapter dragPointAdapter;

    @Override
    protected int getContentLayout() {
        return R.layout.activity_dragpoint;
    }

    @Override
    protected void initGui() {
        recyclerView = (RecyclerView) findViewById(R.id.dragpoint_recyclerview);
    }

    @Override
    protected void initAction() {

    }

    @Override
    protected void initData() {
        init();
    }

    private void init() {
        for (int i = 0; i < 30; i++) {
            list.add(new DragPointBean(i));
        }

        dragPointAdapter = new DragPointAdapter(this, list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(dragPointAdapter);
    }
}
