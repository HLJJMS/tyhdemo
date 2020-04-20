package wlm.tyhkj;

import android.app.Service;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import wlm.adapter.CommentAdapter;
import wlm.adapter.CommentBean;

public class CommentActivity extends AppCompatActivity {

    @InjectView(R.id.title)
    TextView title;
    @InjectView(R.id.recycler)
    RecyclerView recycler;
    @InjectView(R.id.input_txt)
    TextView inputTxt;
    @InjectView(R.id.img_comment)
    ImageView imgComment;
    @InjectView(R.id.txt_comment_int)
    TextView txtCommentInt;
    @InjectView(R.id.img_good)
    ImageView imgGood;
    @InjectView(R.id.txt_good_int)
    TextView txtGoodInt;
    CommentAdapter adapter;
    List<CommentBean> list = new ArrayList<>();
    String inputText;
    int page = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        ButterKnife.inject(this);
        list.add(new CommentBean(0, "小明", "来我家玩"));
        list.add(new CommentBean(0, "小刚", "asdsadsadsaxzcxzcz"));
        list.add(new CommentBean(1, "小李", "来我家玩"));
        list.add(new CommentBean(1, "小王", "asdsadsadsaxzcxzcz"));
        list.add(new CommentBean(0, "皮长山", "asdsadsadsaxzcxzcz"));
        list.add(new CommentBean(0, "流量", "asdsadsadsaxzcxzcz"));
        list.add(new CommentBean(0, "王玉丽", "asdsadsadsaxzcxzcz"));
        list.add(new CommentBean(1, "春暖花开", "asdsadsadsaxzcxzcz"));
        list.add(new CommentBean(0, "terry", "asdsadsadsaxzcxzcz"));
        list.add(new CommentBean(1, "走吧", "asdsadsadsaxzcxzcz"));
        list.add(new CommentBean(1, "UIUI", "asdsadsadsaxzcxzcz"));
        list.add(new CommentBean(1, "千万", "asdsadsadsaxzcxzcz"));
        list.add(new CommentBean(1, "是我", "asdsadsadsaxzcxzcz"));
        list.add(new CommentBean(1, "刘晓庆", "asdsadsadsaxzcxzcz"));
        list.add(new CommentBean(0, "白桦树", "asdsadsadsaxzcxzcz"));
        list.add(new CommentBean(1, "毛毛狗", "asdsadsadsaxzcxzcz"));
        list.add(new CommentBean(1, "1315", "asdsadsadsaxzcxzcz"));
        list.add(new CommentBean(1, "月亮", "asdsadsadsaxzcxzcz"));
        list.add(new CommentBean(1, "白天", "asdsadsadsaxzcxzcz"));
        list.add(new CommentBean(1, "晚上", "asdsadsadsaxzcxzcz"));
        list.add(new CommentBean(1, "闹有人", "asdsadsadsaxzcxzcz"));
        list.add(new CommentBean(0, "asdsadsada", "asdsadsadsaxzcxzcz"));
        adapter = new CommentAdapter(list);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);

        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                page++;
                addSomeThing();
            }

        }, recycler);
    }

    private void addSomeThing() {
        if (page<4){
            adapter.addData(list);
            adapter.loadMoreComplete();
        }else{
            adapter.loadMoreEnd();
        }

    }

    @OnClick({R.id.input_txt, R.id.img_comment})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.input_txt:
                PopupWindow window = new PopupWindow(this);
                View popView = LayoutInflater.from(this).inflate(R.layout.pop_comment_input, null);
                window.setBackgroundDrawable(new ColorDrawable(0xffffffff));
                window.setContentView(popView);
                window.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                window.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                window.setFocusable(true);
                window.setOutsideTouchable(true);
                TextView number = popView.findViewById(R.id.number);
                EditText input = popView.findViewById(R.id.input);
                QMUIRoundButton button = popView.findViewById(R.id.ok);
                input.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        if (s.length() > 300) {
                            number.setText(String.valueOf(s.length()));
                            number.setTextColor(Color.RED);
                        } else {
                            number.setText(String.valueOf(s.length()));
                            number.setTextColor(Color.GRAY);
                        }

                        inputText = s.toString();
                    }
                });
                window.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        bgAlpha(1.0f);
                    }
                });
                window.setAnimationStyle(R.style.popwindow_anim_style);
                window.showAtLocation(getWindow().getDecorView(),
                        Gravity.BOTTOM, 0, 0);
                bgAlpha(0.618f);
                input.setText(inputText);
                InputMethodManager imm = (InputMethodManager) input.getContext().getSystemService(Service.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                break;
            case R.id.img_comment:
                break;
        }
    }

    private void bgAlpha(float f) {
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.alpha = f;
        getWindow().setAttributes(layoutParams);
    }
}
