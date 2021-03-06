package wlm.tyhkj;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;;
import android.view.View;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.BindView;
import butterknife.OnClick;
import wlm.base.TestDB;

public class SqlActivity extends AppCompatActivity {

    @BindView(R.id.add)
    TextView add;
    @BindView(R.id.read)
    TextView read;
    @BindView(R.id.tv_result)
    TextView tvResult;
    @BindView(R.id.tv_updata)
    TextView tvUpdata;
    @BindView(R.id.tv_deldata)
    TextView tvDeldata;
    private TestDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);
        ButterKnife.bind(this);
        db = new TestDB(this);
    }


    @OnClick({R.id.tv_result, R.id.add, R.id.read,R.id.tv_updata,R.id.tv_deldata})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_result:
                break;
            case R.id.add:
                db.addData("皮长山", "35", "男");
                break;
            case R.id.read:
                tvResult.setText(db.readSomeThing("皮长山"));
                break;
            case R.id.tv_updata:
                db.upData("name","皮长山","女");
                break;
            case R.id.tv_deldata:
                break;
        }
    }
}
