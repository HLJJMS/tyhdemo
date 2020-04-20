package wlm.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import wlm.tyhkj.R;

/**
 * Created by wlm on 2018/8/28.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.viewHolder> {
    private Context mContext;
    private int moveX = 0;
    private List<String> list = new ArrayList<>();
    private Scroller mScroller;

    public RecyclerAdapter(Context context) {
        this.mContext = context;
    }

    private View view;

    public void setData(List<String> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerAdapter.viewHolder holder, final int position) {
        holder.item_main.setText(list.get(position));
        holder.itemDel.setText(list.get(position));
        final int delSize = holder.itemDel.getWidth();
        mScroller = new Scroller(mContext);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    public Boolean onTouchEvent(MotionEvent e) {
        Log.e("adapter", "go");
        return true;
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        public TextView item_main, itemDel;
        public LinearLayout all;

        public viewHolder(View itemView) {
            super(itemView);
            item_main = (TextView) itemView.findViewById(R.id.item_main);
            itemDel = (TextView) itemView.findViewById(R.id.item_del);
            all = (LinearLayout) itemView.findViewById(R.id.all);
        }
    }
}
