package wlm.diyview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import wlm.adapter.RecyclerAdapter;

/**
 * Created by wlm on 2018/8/28.
 */

public class MyRecyclerView extends RecyclerView {
    private Context mContext;
    private VelocityTracker mVelocityTracker;
    private Scroller mScroller;
    //4种状态，分别为关闭、正在关闭、正在打开、打开
    private int status = CLOSE , p ,ML;
    TextView main , del;
    public static final int CLOSE = 0;
    public static final int CLOSING = 1;
    public static final int OPENING = 2;
    public static final int OPEN = 3;
    private Context context;
    public MyRecyclerView(Context context) {

        super(context,null);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs,0);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {

        super(context, attrs, defStyle);
        this.context = context;
        mVelocityTracker = VelocityTracker.obtain();
    }
    @Override
    public boolean onTouchEvent(MotionEvent e) {

        int x = (int)e.getX();//获得当前点击的X坐标
        int y = (int)e.getY();//获得当前点击的Y坐标
        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(status==CLOSE){
                    View view = findChildViewUnder(x,y);
                    if(null==view){
                        return false;
                    }
                    RecyclerAdapter.viewHolder holder = (RecyclerAdapter.viewHolder)getChildViewHolder(view);
                    del = holder.itemDel;
                    main = holder.item_main;
                    p = holder.getAdapterPosition();
                    ML = del.getWidth();
                    del.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(context,String.valueOf(p)+"del",Toast.LENGTH_LONG);
                        }
                    });
                }else if(status==OPEN){

                }else{
                    return false;
                }
               break;
            case MotionEvent.ACTION_MOVE:

            case MotionEvent.ACTION_UP:
        }

        return false;
    }
}
