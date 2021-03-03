package wlm.tyhkj

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_money.*
import kotlinx.android.synthetic.main.pop_comment_input.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import wlm.adapter.MoneyAdapter
import wlm.base.MoneyBean
import wlm.base.retrofit.Retrofit


class MoneyActivity : AppCompatActivity() {
    var adapter: MoneyAdapter = MoneyAdapter()
    var url = "https://webapi.sporttery.cn/gateway/lottery/getHistoryPageListV1.qry?gameNo=85&provinceId=0&pageSize=3000&isVerify=1&pageNo=1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_money)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter
        tv_ok.setOnClickListener {
            var zhongjiang = false
            var bean = adapter.data
            for (index in 0..bean.size - 1) {
                if (et_search.text.toString().equals(bean.get(index).lotteryDrawResult)) {
                    txt.setText("中奖期数:"+bean.get(index).lotteryDrawNum + " ")
                    zhongjiang = true
                    break
                }
                if(!zhongjiang&&index == bean.size-1){
                    txt.setText("没有中奖")
                }
            }
        }
        get()
    }


    fun get() {
        var retrofit = Retrofit.getRetrofit()
        val call: Call<MoneyBean> = retrofit.getService().caipiao(url)
        call.enqueue(object : Callback<MoneyBean?> {
            override fun onFailure(call: Call<MoneyBean?>, t: Throwable) {
                Log.e("sadasd", t.toString())
            }

            override fun onResponse(call: Call<MoneyBean?>, response: Response<MoneyBean?>) {
                adapter.setNewData(response.body()?.value?.list)

            }
        })

    }
}
