package wlm.diyview;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import wlm.tyhkj.R;

public class TextDiy extends View {
    int height,width;
    public TextDiy(Context context) {
        super(context);
    }

    public TextDiy(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TextDiy(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TextDiy(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
        Log.e("模式宽2222",String.valueOf(getMeasuredWidth()));

        Log.e("模式宽",String.valueOf(MeasureSpec.getMode(widthMeasureSpec)));
        Log.e("大小宽",String.valueOf(MeasureSpec.getSize(widthMeasureSpec)));
        Log.e("模式搞",String.valueOf(MeasureSpec.getMode(heightMeasureSpec)));
        Log.e("大小搞",String.valueOf(MeasureSpec.getSize(heightMeasureSpec)));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        canvas.drawRect(getLeft(),getTop(),getLeft()+getMeasuredWidth(),getTop()+getMeasuredHeight(),paint);
        Paint paintTxt = new Paint();
        paintTxt.setColor(Color.BLUE);
        paintTxt.setTextSize(30);
        paintTxt.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("asdasdsad",getLeft()+getMeasuredWidth()/2,getTop()+getMeasuredHeight()/2,paintTxt);
        Paint imgPaint = new Paint();
        Rect rect = new Rect(getLeft()+getMeasuredWidth()-500,getTop()+(getMeasuredHeight()-50)/2,getLeft()+getMeasuredWidth(),getTop()+(getMeasuredHeight()+50)/2);
        RectF rectF = new RectF(getLeft()+getMeasuredWidth()-50,getTop(),getLeft()+getMeasuredWidth(),getTop()+getMeasuredHeight());
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),R.mipmap.colse),rect,rectF,paint);
    }
}
