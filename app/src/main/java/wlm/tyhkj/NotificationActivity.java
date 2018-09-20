package wlm.tyhkj;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.common.Constants;

import java.lang.ref.WeakReference;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class NotificationActivity extends AppCompatActivity {
    @InjectView(R.id.start)
    TextView start;
    @InjectView(R.id.end)
    TextView end;
    @InjectView(R.id.xg)
    TextView xg;
    Context context;
    private Message m;
//    private  TencentPush receiver = new TencentPush();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.inject(this);
        context = this;
        Handler handler = new HandlerExtension(NotificationActivity.this);
        m = handler.obtainMessage();
        baseXg();
    }

    private void baseXg() {
        XGPushManager.registerPush(getApplicationContext(),
                new XGIOperateCallback() {
                    @Override
                    public void onSuccess(Object data, int flag) {
                        Log.w("结果   ", "+++ register push sucess. token:" + data + "flag" + flag);

                        m.obj = "+++ register push sucess. token:" + data;
                        m.sendToTarget();
                    }

                    @Override
                    public void onFail(Object data, int errCode, String msg) {
                        Log.w(Constants.LogTag,
                                "+++ register push fail. token:" + data
                                        + ", errCode:" + errCode + ",msg:"
                                        + msg);
                        m.obj = "+++ register push fail. token:" + data
                                + ", errCode:" + errCode + ",msg:" + msg;
                        m.sendToTarget();
                    }
                });
    }

    @OnClick({R.id.start, R.id.end, R.id.xg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.start:
                baseMessage();
                break;
            case R.id.end:
                xuanguaMessage();
                break;
            case R.id.xg:
                xgMessage();
        }
    }

    private void xgMessage() {

    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void xuanguaMessage() {
        Notification.Builder builder = new Notification.Builder(this);

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent)
                .setContentText("contenttext")
                .setContentTitle("contenttitle")
                .setSubText("subtext")
                .setAutoCancel(false)
                .setFullScreenIntent(pendingIntent, true)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        Notification notification = builder.build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void baseMessage() {

        NotificationManager mNManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder mBuilder = new Notification.Builder(this);
        Intent it = new Intent(this, MainActivity.class);
        PendingIntent pit = PendingIntent.getActivity(this, 0, it, 0);
        mBuilder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.car)).setSmallIcon(R.drawable.car).setContentText("laial").setContentTitle("12121").setNumber(3).setAutoCancel(true)                           //设置点击后取消Notification
                .setContentIntent(pit).setFullScreenIntent(pit, true);

        Notification notify1 = mBuilder.build();
        mNManager.notify(1, notify1);

    }

    class HandlerExtension extends Handler {
        WeakReference<Activity> mActivity;

        HandlerExtension(Activity activity) {
            mActivity = new WeakReference<Activity>(activity);
        }
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Activity theActivity = mActivity.get();
            if (theActivity == null) {
                theActivity = new MainActivity();
            }
            if (msg != null) {
                Log.d("TPush", msg.obj.toString());
                xg.setText(XGPushConfig.getToken(theActivity));
            }
            // XGPushManager.registerCustomNotification(theActivity,
            // "BACKSTREET", "BOYS", System.currentTimeMillis() + 5000, 0);
        }
    }
    @Override
    protected void onDestroy() {
//        unregisterReceiver(updateListViewReceiver);
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        XGPushManager.onActivityStoped(this);
    }

}
