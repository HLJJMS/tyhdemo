package wlm.tyhkj;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class HandlerActivity extends AppCompatActivity {


    @InjectView(R.id.starthandler)
    TextView starthandler;
    @InjectView(R.id.endhandler)
    TextView endhandler;
    @InjectView(R.id.num)
    TextView num;
    private Boolean flag = true;
    private Thread myThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_handler);
        ButterKnife.inject(this);

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
