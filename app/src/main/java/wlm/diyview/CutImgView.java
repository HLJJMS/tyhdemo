package wlm.diyview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CutImgView extends View {
    private int sl,st,sr,sb,lastX,lastY;
    public CutImgView(Context context) {
        super(context);
    }

    public CutImgView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CutImgView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(70f);
        canvas.drawPoint(100, 100, paint);
        canvas.drawPoint(300,300,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        //获取手机触摸的坐标
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                sl=getLeft();
                sr=getRight();
                st=getTop();
                sb = getBottom();
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                layout(sl+x-lastX,st+y-lastY,sr+x-lastX,sb+y-lastY);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }
}
