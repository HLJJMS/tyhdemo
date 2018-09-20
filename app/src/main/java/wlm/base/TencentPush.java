package wlm.base;

import android.content.Context;
import android.util.Log;

import com.tencent.android.tpush.XGPushBaseReceiver;
import com.tencent.android.tpush.XGPushClickedResult;
import com.tencent.android.tpush.XGPushRegisterResult;
import com.tencent.android.tpush.XGPushShowedResult;
import com.tencent.android.tpush.XGPushTextMessage;

/**
 * Created by wlm on 2018/9/19.
 */

public class TencentPush extends XGPushBaseReceiver {
    @Override
    public void onRegisterResult(Context context, int i, XGPushRegisterResult xgPushRegisterResult) {

    }

    @Override
    public void onUnregisterResult(Context context, int i) {

    }

    @Override
    public void onSetTagResult(Context context, int i, String s) {

    }

    @Override
    public void onDeleteTagResult(Context context, int i, String s) {

    }

    @Override
    public void onTextMessage(Context context, XGPushTextMessage xgPushTextMessage) {
        Log.e("消息",xgPushTextMessage.toString());
    }

    @Override
    public void onNotifactionClickedResult(Context context, XGPushClickedResult xgPushClickedResult) {

    }

    @Override
    public void onNotifactionShowedResult(Context context, XGPushShowedResult xgPushShowedResult) {
        String title = xgPushShowedResult.getTitle();
        String activitys = xgPushShowedResult.getActivity();
        String custom = xgPushShowedResult.getCustomContent();
        String concent =xgPushShowedResult.getContent();
        int type = xgPushShowedResult.getNotificationActionType();
        int id = xgPushShowedResult.getNotifactionId();
        Log.e("title",title);
        Log.e("activitys",activitys);
        Log.e("custom",custom);
        Log.e("concent",concent);
        Log.e("type",String.valueOf(type));
        Log.e("id",String.valueOf(id));
    }
}
