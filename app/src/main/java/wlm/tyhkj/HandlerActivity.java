package wlm.tyhkj;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.BindView;
import butterknife.OnClick;

public class HandlerActivity extends AppCompatActivity {


    @BindView(R.id.starthandler)
    TextView starthandler;
    @BindView(R.id.endhandler)
    TextView endhandler;
    @BindView(R.id.num)
    TextView num;
    private Boolean flag = true;
    private Thread myThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_handler);
        ButterKnife.bind(this);

        myThread = new Thread(new MyThread());
    }

    @OnClick({R.id.starthandler, R.id.endhandler})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.starthandler:
                flag = true;
                myThread.start();
                break;
            case R.id.endhandler:
                flag = false;
                break;
        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
//           num.setText(msg.getData().getString("num")+msg.getData().getString("name"));
            num.setText(String.valueOf(msg.arg1));

        }
    };

    class MyThread implements Runnable {

        @Override
        public void run() {
            while (flag) {
                Log.e("MYTREAD", Thread.currentThread().getName());
                Message msg = new Message();
//                Bundle b = new Bundle();
//                b.putString("num",String.valueOf((int)(1+Math.random()*(10000-1+1))));
//                b.putString("name",Thread.currentThread().getName());
//                msg.setData(b);
                msg.arg1 = (int) (1 + Math.random() * (10000 - 1 + 1));
                handler.sendMessage(msg);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    protected void onStop() {
        flag = false;
        super.onStop();

    }
}
