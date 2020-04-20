package wlm.tyhkj;

import android.os.AsyncTask;
import android.os.Bundle;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.alibaba.fastjson.JSONObject;
import com.bin.david.form.core.SmartTable;
import com.bin.david.form.data.CellInfo;
import com.bin.david.form.data.format.bg.BaseCellBackgroundFormat;
import com.bin.david.form.data.table.TableData;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import wlm.bean.Form;

public class FormActivity extends AppCompatActivity {
    OkHttpClient client = new OkHttpClient();

    SmartTable<Form.MyDynamicDataBean> table;
    Form form = new Form();
    List<Form.MyDynamicDataBean> list = new ArrayList<>();
    private TableData tableData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        ButterKnife.inject(this);
        table = (SmartTable<Form.MyDynamicDataBean>) findViewById(R.id.table);
        table.getConfig().setContentCellBackgroundFormat(new BaseCellBackgroundFormat<CellInfo>() {
            @Override
            public int getTextColor(CellInfo cellInfo) {
                if (cellInfo.col == 0) {
                    return ContextCompat.getColor(FormActivity.this, R.color.white);
                } else {
                    return ContextCompat.getColor(FormActivity.this, R.color.black);
                }
            }

            @Override
            public int getBackGroundColor(CellInfo cellInfo) {
                if (cellInfo.col == 0) {
                    return ContextCompat.getColor(FormActivity.this, R.color.colorAccent);
                }
                if (cellInfo.row == 0) {
                    return ContextCompat.getColor(FormActivity.this, R.color.black_translucent);
                } else if (cellInfo.row % 2 == 1) {
                    return ContextCompat.getColor(FormActivity.this, R.color.black_translucent);
                } else {
                    return ContextCompat.getColor(FormActivity.this, R.color.white);
                }


            }
        });
        table.setData(list);
        getDate();
    }


    private void getDate() {
        Qingqiu qingqiu = new Qingqiu();
        qingqiu.execute();

    }

    class Qingqiu extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            String s = "";
            Request request = new Request.Builder().url("http://192.168.1.137:8666/api/ZQZYBasicsApi/CommonList?a=TR0003&b=1|2|3|4|9|10|15").get().build();
            try {
                Response response = client.newCall(request).execute();
                s = response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return s;
        }

        @Override
        protected void onPostExecute(String s) {
            Log.e("结果", s);
            JSONObject jsonObject = JSONObject.parseObject(s);
            Gson gson = new Gson();
            form = gson.fromJson(jsonObject.toJSONString(), Form.class);
            super.onPostExecute(s);
            list.addAll(form.getMyDynamicData());
            table.setData(list);
        }
    }

}
