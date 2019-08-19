package com.example.mvpkuangjia2.app.netRequest;


import com.example.mvpkuangjia2.mvp.model.api.service.CommonService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by goldze on 2017/5/10.
 * RetrofitClient封装单例类, 实现网络请求
 */
public class GeRetrofitClient {
    private static CommonService mService;

    public static CommonService getmService() {
        return getService();
    }

    private static CommonService getService() {
        if (mService == null) {
            OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().
                    connectTimeout(60, TimeUnit.SECONDS).
                    readTimeout(60, TimeUnit.SECONDS).
                    writeTimeout(60, TimeUnit.SECONDS);
//                .cache(cache)
                    // 添加签名参数

            mService = new Retrofit.Builder()
                    .baseUrl("http://hc.hcsxj.cn")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(httpClientBuilder.build())
                    .build()
                    .create(CommonService.class);
        }
        return mService;
    }

}
