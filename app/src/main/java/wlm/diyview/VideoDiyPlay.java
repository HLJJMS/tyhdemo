package wlm.diyview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import cn.jzvd.JzvdStd;

public class VideoDiyPlay extends JzvdStd {
    int startX, startY , x , y ,progress;
    long position,duration;
    boolean isHorizontal = true;
    public VideoDiyPlay(Context context) {
        super(context);
    }

    public VideoDiyPlay(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        y = (int) event.getY();
        x = (int) event.getX();
       switch (event.getAction()){
           case MotionEvent.ACTION_DOWN:
               startY = (int) event.getRawY();
               startX =(int) event.getRawX();
               Log.e("起点坐标X",String.valueOf(startX));
               Log.e("起点坐标Y",String.valueOf(startY));
               break;
           case MotionEvent.ACTION_MOVE:
               Log.e("移动坐标RAWX", String.valueOf(event.getRawX()));
               Log.e("移动坐标RAWY" , String.valueOf(event.getRawY()));
               Log.e("移动坐标X" , String.valueOf(event.getX()));
               Log.e("移动坐标Y" , String.valueOf(event.getY()));
               Log.e("空间宽度", String.valueOf(getMeasuredWidth()));
               Log.e("控件高度",String.valueOf(getMeasuredHeight()));
               Log.e("左侧支",String.valueOf(getLeft()));
//               startDismissControlViewTimer();
               float  bfb= x/getMeasuredWidth();
//               bottomProgressBar.setProgress(bfb);
                long time = (long)bfb*duration;
                int proressint = x*100/getMeasuredWidth();
               progressBar.setProgress(proressint);
//                progressBar.setSecondaryProgress(proressint);
               break;
           case MotionEvent.ACTION_UP:

               break;
       }
        return super.onTouch(v, event);
    }


    @Override
    public void onProgress(int progress, long position, long duration) {
        super.onProgress(progress, position, duration);
        this.position = position;
        this.duration = duration;
        this.progress = progress;
    }
}
