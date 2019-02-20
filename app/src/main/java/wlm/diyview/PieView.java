package wlm.diyview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import wlm.bean.PieBean;

public class PieView extends View {
    private List<PieBean> list = new ArrayList<>();
    private int size = 0, height, width, zero,paddingLeft=0,paddingRight=0,paddingTop=0,paddingBottom=0;
    private final int WRAP_WIDTH = 200;
    private final int WRAP_HEIGHT = 200;
    private float c = 0;

    public PieView(Context context) {
        super(context);

    }


    public PieView(Context context, AttributeSet attrs) {
        super(context, attrs);
        
    }

    public PieView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PieView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(WRAP_WIDTH, WRAP_HEIGHT);
        } else if (widthMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(WRAP_WIDTH, height);
        } else if (heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(width, WRAP_HEIGHT);
        }
        paddingLeft = getPaddingLeft();
        paddingRight = getPaddingRight();
        paddingTop = getPaddingTop();
        paddingBottom = getPaddingBottom();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        height = getHeight()-paddingBottom-paddingTop;
        width = getWidth()-paddingLeft-paddingRight;

        for (int i = 0; i < list.size(); i++) {
            Paint paint = new Paint();
            paint.setStrokeWidth(10f);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(list.get(i).getColor());
            if (width > height) {
                canvas.drawArc(new RectF((width - height) / 2, 0, width / 2 + height / 2, height), c * 360, list.get(i).getNumber() * 360, true, paint);
            } else {
                canvas.drawArc(new RectF(0, (height - width) / 2, width, width / 2 + height / 2), c * 360, list.get(i).getNumber() * 360, true, paint);
            }

            c = list.get(i).getNumber() + c;
        }
//        Paint p = new Paint();
//        p.setStrokeWidth(10f);
//        p.setStyle(Paint.Style.STROKE);
//        p.setColor(Color.BLUE);
//        canvas.drawRect(new RectF((width-height)/2,0,width/2+height/2,height),p);
    }

    public void setList(List<PieBean> list) {
        this.list.clear();
        this.list.addAll(list);
        size = list.size();
        invalidate();
    }
}
