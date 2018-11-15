package wlm.base;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;


/**
 * Created by wlm on 2018/9/7.
 */

public class PermissionDynamic {
    public void ReadAndWrite(Activity activity) {
//        if (ContextCompat.checkSelfPermission(activity,
//                Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                != PackageManager.PERMISSION_GRANTED) {
//            if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
//                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
//            } else {
//                ActivityCompat.requestPermissions(activity,
//                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                                Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
//            }
//        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int white = ContextCompat.checkSelfPermission(activity, Manifest.permission. WRITE_EXTERNAL_STORAGE);
            int read = ContextCompat.checkSelfPermission(activity, Manifest.permission. READ_EXTERNAL_STORAGE);
            if ( white== PackageManager.PERMISSION_GRANTED&&PackageManager.PERMISSION_GRANTED==read){
                Log.e("可以", "可以" );

            } else {
                Log.e("禁止", "禁止" );
                ActivityCompat.requestPermissions(activity,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
            }
        } else {
            Log.e("地下", "M以下");

        }



    }
    //百度地图动态位置权限申请
    public void Location(Activity activity) {
        int checkPermission = ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION);
        if (checkPermission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
            Log.e("申请成功", "申请成功");

        }
    }
}