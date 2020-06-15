package febb.renwa_client.net;



import java.io.IOException;
import java.util.concurrent.TimeUnit;


import febb.renwa_client.BuildConfig;
import febb.renwa_client.common.Construct;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(AppClient.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static HttpLoggingInterceptor logging = getLoggingInterceptor();

    private static HttpLoggingInterceptor getLoggingInterceptor() {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
//        if (BuildConfig.DEBUG) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        } else {
//            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
//        }

        return loggingInterceptor;
    }


    private static Retrofit retrofit = builder.build();

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Interceptor header = getHeaderInterceptor();
//    private static Interceptor header = "";

    private static Interceptor getHeaderInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                return chain.proceed(
                        chain.request().newBuilder()
//                                .addHeader("X-COIN-Application-Key", Construct.APPLICATION_KEY)
                                .addHeader("X-COIN-Signature", "")
                                .addHeader("X-COIN-Timestamp", "")
                                .addHeader("X-COIN-Session-Token", "")
                                .build()
                );
            }
        };
    }


    public static <S> S createService(Class<S> serviceClass) {

        //静的な共通リクエストヘッダーの追加
        if (!httpClient.interceptors().contains(header)) {
            httpClient.addInterceptor(header);
        }
        //ログ
        if (!httpClient.interceptors().contains(logging)) {
            httpClient.addInterceptor(logging);
        }

        httpClient.connectTimeout(30, TimeUnit.SECONDS);
        httpClient.readTimeout(30, TimeUnit.SECONDS);
        httpClient.writeTimeout(30, TimeUnit.SECONDS);

        builder.client(httpClient.build());
        retrofit = builder.build();

        return retrofit.create(serviceClass);
    }

    public static Retrofit retrofit() {
        return retrofit;
    }
}