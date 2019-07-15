package wlm.diyview;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;

import wlm.tyhkj.R;

public class BottomPopwindow extends PopupWindow {
    Context context;
    public BottomPopwindow(Context context) {
        super(context);
        this.context = context;
    }

    public BottomPopwindow(View contentView) {
        super(contentView);
    }


    @Override
    public void dismiss() {
        super.dismiss();
    }

    @Override
    public void showAtLocation(View parent, int gravity, int x, int y) {
        super.showAtLocation(parent, gravity, x, y);
    }

    @Override
    public void setAnimationStyle(int animationStyle) {
        super.setAnimationStyle(R.style.popwindow_anim_style);
    }
}
