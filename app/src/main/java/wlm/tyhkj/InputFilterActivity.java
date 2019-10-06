package wlm.tyhkj;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import wlm.diyview.IDCardEditText;

public class InputFilterActivity extends AppCompatActivity {

    @InjectView(R.id.test_input)
    IDCardEditText testInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_filter);
        ButterKnife.inject(this);
    }
}
