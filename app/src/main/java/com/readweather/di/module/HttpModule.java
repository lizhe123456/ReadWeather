package com.readweather.di.module;

import com.readweather.app.App;
import com.readweather.app.Constants;
import com.readweather.di.qualifier.BusUrl;
import com.readweather.di.qualifier.GirlsUrl;
import com.readweather.di.qualifier.ReadUrl;
import com.readweather.di.qualifier.WeatherUrl;
import com.readweather.model.http.api.BusApi;
import com.readweather.model.http.api.GirlsApi;
import com.readweather.model.http.api.ReadApi;
import com.readweather.model.http.api.WeatherApi;
import com.readweather.utils.JsonUtil;
import com.readweather.utils.LogUtil;
import com.readweather.utils.SystemUtil;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/8/18 0018.
 */
@Module
public class HttpModule {

    @Singleton
    @Provides
    Retrofit.Builder provideRetrofitBuilder(){
        return new Retrofit.Builder();
    }

    @Singleton
    @Provides
    OkHttpClient.Builder provideOkHttpBuilder(){
        return new OkHttpClient.Builder();
    }

    @Singleton
    @Provides
    @BusUrl
    Retrofit provideBusRetrofit(Retrofit.Builder builder,OkHttpClient client){
        return createRetrofit(builder,client,Constants.BUS_API);
    }

    @Singleton
    @Provides
    @GirlsUrl
    Retrofit provideGirlRetrofit(Retrofit.Builder builder,OkHttpClient client){
        return createRetrofit(builder,client,Constants.GIRLS_API);
    }

    @Singleton
    @Provides
    @ReadUrl
    Retrofit provideReadRetrofit(Retrofit.Builder builder, OkHttpClient client){
        return createRetrofit(builder,client, Constants.READ_API);
    }

    @Singleton
    @Provides
    @WeatherUrl
    Retrofit provideWeatherRetrofit(Retrofit.Builder builder, OkHttpClient client){
        return createRetrofit(builder,client, Constants.WEATHER_API);
    }

    @Singleton
    @Provides
    BusApi provideBusService(@BusUrl Retrofit retrofit){
        return retrofit.create(BusApi.class);
    }

    @Singleton
    @Provides
    GirlsApi provideGirlsService(@GirlsUrl Retrofit retrofit){
        return retrofit.create(GirlsApi.class);
    }

    @Singleton
    @Provides
    ReadApi provideReadService(@ReadUrl Retrofit retrofit){
        return retrofit.create(ReadApi.class);
    }

    @Singleton
    @Provides
    WeatherApi provideWeatherService(@WeatherUrl Retrofit retrofit){
        return retrofit.create(WeatherApi.class);
    }

    @Singleton
    @Provides
    OkHttpClient provideClient(OkHttpClient.Builder builder) {
            HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor(new HttpLogger());
            logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            File cacheFile = new File(Constants.PATH_CACHE);
            Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
            Interceptor cacheInterceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();
                    if (!SystemUtil.isNetworkConnected(App.getContext())) {
                        request = request.newBuilder()
                                .cacheControl(CacheControl.FORCE_CACHE)
                                .build();
                    }
                    Response response = chain.proceed(request);
                    if (SystemUtil.isNetworkConnected(App.getContext())) {
                        int maxAge = 0;
                        // 有网络时, 不缓存, 最大保存时长为0
                        response.newBuilder()
                                .header("Cache-Control", "public, max-age=" + maxAge)
                                .removeHeader("Pragma")
                                .build();
                    } else {
                        // 无网络时，设置超时为4周
                        int maxStale = 60 * 60 * 24 * 28;
                        response.newBuilder()
                                .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                                .removeHeader("Pragma")
                                .build();
                    }
                    return response;
                }
            };
//        Interceptor apikey = new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request request = chain.request();
//                request = request.newBuilder()
//                        .addHeader("apikey",Constants.KEY_API)
//                        .build();
//                return chain.proceed(request);
//            }
//        }
//        设置统一的请求头部参数
//        builder.addInterceptor(apikey);
        builder.connectTimeout(15, TimeUnit.SECONDS)
                .addInterceptor(logInterceptor)
                .addNetworkInterceptor(cacheInterceptor)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .cache(cache)
                .addInterceptor(cacheInterceptor);

        return builder.build();
    }

    private Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient client, String url) {
        return builder
                .baseUrl(url)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * http完整日志打印
     */
    private class HttpLogger implements HttpLoggingInterceptor.Logger{

        private StringBuilder mMessage = new StringBuilder();

        @Override
        public void log(String message) {
            // 请求或者响应开始
            if (message.startsWith("--> POST")) {
                mMessage.setLength(0);
            }
            // 以{}或者[]形式的说明是响应结果的json数据，需要进行格式化
            if ((message.startsWith("{") && message.endsWith("}"))
                    || (message.startsWith("[") && message.endsWith("]"))) {
                message = JsonUtil.formatJson(JsonUtil.decodeUnicode(message));
            }
            mMessage.append(message.concat("\n"));
            // 响应结束，打印整条日志
            if (message.startsWith("<-- END HTTP")) {
                LogUtil.d(mMessage.toString());
            }
        }
    }
}
