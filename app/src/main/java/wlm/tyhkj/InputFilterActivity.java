package wlm.tyhkj;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.BindView;
import wlm.diyview.IDCardEditText;

public class InputFilterActivity extends AppCompatActivity {

    @BindView(R.id.test_input)
    IDCardEditText testInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_filter);
        ButterKnife.bind(this);
    }
}
