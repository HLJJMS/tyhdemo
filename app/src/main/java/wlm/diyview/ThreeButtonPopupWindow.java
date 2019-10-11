package wlm.diyview;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;


import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

import wlm.tyhkj.R;

public class ThreeButtonPopupWindow {
    private Reference<Activity> activity;
    private PopupWindow popupWindow;
    private ViewGroup popupWindowViewGroup;

    private QMUIRoundButton oneButton;
    private QMUIRoundButton twoButton;
    private QMUIRoundButton cancel;
    private int time = 300;

    public ButtonClick buttonClick;


    public ThreeButtonPopupWindow(Activity activity) {
        this.activity = new WeakReference<>(activity);
        setPopupWindow();
    }

    public void setPopupWindow() {
        popupWindowViewGroup = (ViewGroup) activity.get().getLayoutInflater().inflate(
                R.layout.popup_three_button, null, true);
        popupWindow = new PopupWindow(popupWindowViewGroup, RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT, false);

        popupWindow.setBackgroundDrawable(new ColorDrawable(-0x1));

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        setBackgroundAlpha(1.0f);
                        activity.get().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                    }
                }, 300);

            }
        });
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setAnimationStyle(R.style.popwindow_anim_style);
        oneButton = (QMUIRoundButton) popupWindowViewGroup.findViewById(R.id.customer);

        twoButton = (QMUIRoundButton) popupWindowViewGroup.findViewById(R.id.call);

        cancel = (QMUIRoundButton) popupWindowViewGroup.findViewById(R.id.cancel);

        //跳转至美洽客服 游客

        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick.setClick(1);
                popupWindow.dismiss();
            }
        });

        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick.setClick(2);
                popupWindow.dismiss();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick.setClick(3);
                popupWindow.dismiss();
            }
        });
    }

    public void setOneButtontText(String msg) {
        oneButton.setText(msg);
    }

    public void setTwoButtontText(String msg) {
        twoButton.setText(msg);
    }

    public void setThreeButtontText(String msg) {
        cancel.setText(msg);
    }


    //    设置popupwindow显示的背景颜色
    private void setBackgroundAlpha(Float color) {
        WindowManager.LayoutParams lp = activity.get().getWindow().getAttributes();
        lp.alpha = color;
        activity.get().getWindow().setAttributes(lp);
    }


    //    popupwindow显示
    public void show() {
        popupWindow.showAtLocation(activity.get().getWindow().getDecorView(),
                Gravity.BOTTOM, 0, 0);
        setBackgroundAlpha(0.618f);
        activity.get().getWindow().
                setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }


    public void dismiss() {
        popupWindow.dismiss();
    }

    public void setOnButtonClick(ButtonClick buttonClick) {
        this.buttonClick = buttonClick;
    }

   public interface ButtonClick {
         void setClick(int id);
    }
}

