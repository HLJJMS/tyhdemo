package wlm.tyhkj;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.realm.Realm;
import wlm.bean.RealmBean;

public class RealmActivity extends AppCompatActivity {

    @InjectView(R.id.txt)
    TextView txt;
    Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm);
        ButterKnife.inject(this);
        Realm.init(this);
         realm = Realm.getDefaultInstance();

        realm.beginTransaction();
        RealmBean bean = realm.createObject(RealmBean.class);
        bean.setAge("4");
        bean.setName("刘小强");
        realm.commitTransaction();

        List<RealmBean> realmBean = realm.where(RealmBean.class).findAll();
        txt.setText(String.valueOf(realmBean.size()));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
