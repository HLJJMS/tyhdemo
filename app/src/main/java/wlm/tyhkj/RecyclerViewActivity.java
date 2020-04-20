package wlm.tyhkj;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;;

import android.text.TextPaint;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import wlm.adapter.RecyclerAdapter;

/**
 * Created by wlm on 2018/8/28.
 */

public class RecyclerViewActivity extends AppCompatActivity {

    //

    private TextPaint t;
    private RecyclerAdapter adapter;
    private RecyclerView recyclerView;
    private Context context;
    private Paint p;
    private List<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        ButterKnife.inject(this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        context = this;
        setList();
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new RecyclerAdapter(this);
        recyclerView.setAdapter(adapter);
        adapter.setData(list);
//        header.attachTo(recyclerView, true);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {

            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDraw(c, parent, state);
                int childCount = parent.getChildCount();
                int left = parent.getPaddingLeft();
                int right = parent.getWidth() - parent.getPaddingRight();
                p = new Paint();
                LinearGradient linearGradient = new LinearGradient((float) left, 0, (float) right, 0, context.getResources().getColor(R.color.colorAccent), context.getResources().getColor(R.color.colorPrimary), Shader.TileMode.MIRROR);
                p.setShader(linearGradient);
                for (int i = 0; i < childCount - 1; i++) {
                    View view = parent.getChildAt(i);
                    float top = view.getBottom();
                    float bottom = view.getBottom() + 5;
                    c.drawRect(left, top, right, bottom, p);
                }
            }

            @Override
            public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDrawOver(c, parent, state);
            }

            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                if (state.getItemCount() - 1 != parent.getChildLayoutPosition(view)) {
                    outRect.bottom = 5;
                }
            }
        });
    }

    private void setList() {
        list.add("TIEM1ONE");
        list.add("TIEM2ONE");
        list.add("TIEM3ONE");
        list.add("TIEM4ONE");
        list.add("TIEM5TWO");
        list.add("TIEM6TWO");
        list.add("TIEM7TWO");
        list.add("TIEM8TWO");
        list.add("TIEM9THREE");
        list.add("TIEM10THREE");
        list.add("TIEM11THREE");
        list.add("TIEM12THREE");
        list.add("TIEM13FOUR");
        list.add("TIEM14FOUR");
        list.add("TIEM15FOUR");
        list.add("TIEM16FOUR");
        list.add("TIEM17FIVE");
        list.add("TIEM18FIVE");
        list.add("TIEM19FIVE");
        list.add("TIEM20FIVE");
    }

}