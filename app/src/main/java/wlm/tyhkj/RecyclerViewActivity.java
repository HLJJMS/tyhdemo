package wlm.tyhkj;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import wlm.adapter.RecyclerAdapter;

/**
 * Created by wlm on 2018/8/28.
 */

public class RecyclerViewActivity extends AppCompatActivity {
//
//    @InjectView(R.id.header)
//    RecyclerViewHeader header;
    private RecyclerAdapter adapter;
    private RecyclerView recyclerView;
    private Paint p;
    private List<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        ButterKnife.inject(this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        p = new Paint();
        p.setColor(this.getResources().getColor(R.color.colorAccent));
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
                outRect.bottom = 5;

            }
        });
    }

    private void setList() {
        list.add("TIEM1");
        list.add("TIEM2");
        list.add("TIEM3");
        list.add("TIEM4");
        list.add("TIEM5");
        list.add("TIEM6");
        list.add("TIEM7");
        list.add("TIEM8");
        list.add("TIEM9");
        list.add("TIEM10");
        list.add("TIEM11");
        list.add("TIEM12");
    }

}