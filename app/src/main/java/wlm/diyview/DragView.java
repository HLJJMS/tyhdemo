package wlm.diyview;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.Toast;

public class DragView extends FloatingActionButton {

    int width, height, startX, startY, x, y, rawX, rawY;


    public DragView(Context context) {
        super(context);
    }

    public DragView(Context context, AttributeSet attrs) {
        super(context, attrs);
        DisplayMetrics dm = new DisplayMetrics();
        height = dm.heightPixels;
        width = dm.widthPixels;
    }

    public DragView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        x = (int) ev.getX();
        y = (int) ev.getY();
        rawX = (int) ev.getRawX();
        rawY = (int )ev.getRawY();

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = x;
                startY = y;
                Log.e("起点坐标", startX + ",,," + startY);
                Log.e("左", String.valueOf(getLeft()));
                Log.e("上", String.valueOf(getTop()));
                Log.e("又", String.valueOf(getRight()));
                Log.e("下", String.valueOf(getRight()));
                break;

            case MotionEvent.ACTION_MOVE:
                if(rawY<0){
                    setXY(x - startX, 0);
                }else if(rawY>height){
                    setXY(x - startX, height);
                }




                setXY(x - startX, y - startY);
                Log.e("移动距离", String.valueOf(x - startX) + ",,," + String.valueOf(y - startY));
                break;

            case MotionEvent.ACTION_UP:
                if (Math.abs(x - startX) < 50 && Math.abs(y - startY) < 50) {
                    Log.e("点击生效", "点击生效");
                }
                if (rawX < width / 2) {
                    layout(0, getTop() + y - startY, getMeasuredWidth(), getBottom() + y - startY);
                } else {
                    layout(width - getMeasuredWidth(), getTop() + y - startY, width, getBottom() + y - startY);
                }






                break;


        }
        return true;

    }

    void setXY(int layoutX, int layoutY) {
        layout(getLeft() + layoutX, getTop() + layoutY, getRight() + layoutX, getBottom() + layoutY);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        ViewGroup mViewGroup = (ViewGroup) getParent();
        if(null != mViewGroup){
            width = mViewGroup.getWidth();
            height = mViewGroup.getHeight();
        }
    }
}
