package wlm.diyview;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by wlm on 2018/9/21.
 */

public class DiyViewText extends View {
    public DiyViewText(Context context) {
        super(context);
    }

    public DiyViewText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DiyViewText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DiyViewText(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

}
