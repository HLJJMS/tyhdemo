package wlm.base.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import wlm.base.MoneyBean;

public interface InterfaceForRetrofit {

    @Streaming
    @GET
    Call<ResponseBody> downLoad(@Url String url);
    @GET
    Call<ResponseBody> test(@Url String url);
    @GET
    Call<MoneyBean> caipiao(@Url String url);
}
