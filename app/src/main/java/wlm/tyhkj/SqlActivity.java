package wlm.tyhkj;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import wlm.base.TestDB;

public class SqlActivity extends AppCompatActivity {

    @InjectView(R.id.add)
    TextView add;
    @InjectView(R.id.read)
    TextView read;
    private TestDB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);
        ButterKnife.inject(this);
        db = new TestDB(this);
    }

    @OnClick({R.id.add, R.id.read})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                db.addSomeThing();
                break;
            case R.id.read:
                read.setText(db.readSomeThing());
                break;
        }
    }
}
