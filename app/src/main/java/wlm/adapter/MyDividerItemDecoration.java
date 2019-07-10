package wlm.adapter;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MyDividerItemDecoration extends RecyclerView.ItemDecoration {
    private Paint mPaint;
    int childCount;

    public MyDividerItemDecoration() {
        this.mPaint = new Paint();
        mPaint.setColor(Color.GREEN);
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);


    }

    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            int index = parent.getChildAdapterPosition(child);
            if (i == 0) {

            } else if (i == 1) {

            }else if(i==childCount - 2){

            }else if(i == childCount-1){

            }else{

            }


        }
    }
}
