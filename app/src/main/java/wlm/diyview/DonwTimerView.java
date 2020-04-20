package wlm.diyview;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.appcompat.widget.AppCompatTextView;

import wlm.tyhkj.R;

public class DonwTimerView extends AppCompatTextView {
    private int timeTotal = 60;
    private int timeSpace = 1000;
    private boolean clickable = true;
    private CountDownTimer countDownTimer;
    public DonwTimerView(Context context) {
        super(context);
        timerTool();

    }

    public DonwTimerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        timerTool();
    }

    public DonwTimerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        timerTool();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                if (clickable) {
                    clickable = false;
                    countDownTimer.start();
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    public void setTimeTotalAndTimeSpace(int timeTotal, int timeSpace) {
        this.timeTotal = timeTotal;
        this.timeSpace = timeSpace;
        timerTool();
    }

   public void timerTool(){
       countDownTimer = new CountDownTimer(timeTotal * 1000 + 500, timeSpace) {
           @Override
           public void onTick(long millisUntilFinished) {
               if (millisUntilFinished / 1000 == 0L) {
                   onFinish();
                   return;
               }
               if (millisUntilFinished / 1000 > 9) {
                   setText(millisUntilFinished / 1000 + "秒重新获取");
               } else {
                   setText("0" + millisUntilFinished / 1000 + "秒重新获取");
               }
               setTextColor(getResources().getColor(R.color.black));
           }

           @Override
           public void onFinish() {
               clickable = true;
               setTextColor(getResources().getColor(R.color.colorAccent));
           }
       };
   }


}
