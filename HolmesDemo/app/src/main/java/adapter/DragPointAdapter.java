package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import bean.DragPointBean;
import team.newwe.holmes.holmesdemo.R;
import view.DragPoint;

/**
 * Created by Administrator on 2016/11/30.
 */

public class DragPointAdapter extends RecyclerView.Adapter<DragPointAdapter.DragPointHolder> {

    private Context context;
    private List<DragPointBean> list = new ArrayList<>();

    public DragPointAdapter(Context context, List<DragPointBean> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public DragPointHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        DragPointHolder dragPointHolder = new DragPointHolder(
                LayoutInflater.from(context).inflate(R.layout.item_dragpoint, parent, false));
        return dragPointHolder;
    }

    @Override
    public void onBindViewHolder(DragPointHolder holder, final int position) {
        holder.dragPoint.setText(list.get(position).getMessageNum() + "");
        holder.dragPoint.setOnDragListener(new DragPoint.OnDragListener() {
            @Override
            public void onDragOut() {
                list.get(position).setRemoved(true);
            }
        });

        /**
         * listview只加载屏幕能够显示的条数，往下滑时会复用上边的view,
         * 例如，第一次能显示0~25条，往下滑时，26条就复用了第0条的view，
         * 所以当第0条view被移除时，第26条view也不见了。
         * 解决方法：在数据信息中加入了一个判断指标：isRemoved，在被移除的回调里设置该变量的值。
         * 之后在每次复用时先判断是否真的被移除，若真的被移除则设置为INVISIBLE，否则为VISIBLE
         */
        if (list.get(position).isRemoved()) {
            holder.dragPoint.setVisibility(View.INVISIBLE);
        } else {
            holder.dragPoint.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class DragPointHolder extends RecyclerView.ViewHolder {

        DragPoint dragPoint;

        public DragPointHolder(View itemView) {
            super(itemView);

            dragPoint = (DragPoint) itemView.findViewById(R.id.dragview);
        }
    }
}
