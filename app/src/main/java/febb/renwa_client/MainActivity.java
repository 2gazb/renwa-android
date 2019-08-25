package febb.renwa_client;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;

import android.content.Intent;
import android.speech.RecognizerIntent;

import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


import febb.renwa_client.net.AppClient;
import febb.renwa_client.net.CustomHTTPHeadersBuilder;
import febb.renwa_client.net.ServiceGenerator;
import okhttp3.HttpUrl;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.FormUrlEncoded;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView txvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txvResult = (TextView) findViewById(R.id.txvResult);
    }

    public void getSpeechInput(View view) {

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 10);
        } else {
            Toast.makeText(this, "Your Device Don't Support Speech Input", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    txvResult.setText(result.get(0));

                    sendAuthCode(result.get(0));

                }
                break;
        }
    }


    private void sendAuthCode(String authCode) {


        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(URL)
//                .client(client)
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .build();



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://flask-env.5csymrfgjb.us-east-2.elasticbeanstalk.com/")
//                .baseUrl("http://127.0.0.1:5000/")
//                .client(client)
//                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

//        retrofit.baseUrl(). += "/getter?name=renwa"

        AppClient service = retrofit.create(AppClient.class);

//        @FormUrlEncoded
        String str = "getter?name=renwa";

        HttpUrl url = HttpUrl.parse("getter?name=renwa");


//        String encodedString = URLEncoder.encode("おすし", "UTF-8");
//        try {
//            final String encodedURL = URLEncoder.encode(str, "Shift-JIS");
            Call<String> call = service.testCall("getter");
//        Call<String> call = service.testCall(url);

//        URL url = new URL(encodedURL);


//        Call<String> call = service.testCall(encodedURL);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("responseresponse", response.toString());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("debug22", t.getMessage());
            }

        });

//        } catch (UnsupportedEncodingException e) {
//            throw new IllegalArgumentException("failed to encode", e);
//        }

//        AppClient client = ServiceGenerator.createService(AppClient.class);
//        Map<String, String> headers = CustomHTTPHeadersBuilder.createHeaders(AppClient.class,
//                "getAuthCode",
////                _sp.getSessionToken()
//                "abcdefg"
//        );
//
//
//        HashMap<String, String> param = new HashMap<>();
////        param.put("mail", mMailAddress);
//
////        param.put("name", String.valueOf(authCode));
////        param.put("name", "renwa");
//
//        param.put("", "");
//
////        showLoadingDlg();
//        Call<String> call = client.testCall(headers, param);
//
//        Log.d(TAG, "responceresponceheaders: " + headers);
//        Log.d(TAG, "responceresponceparam: " + param);
//
//        try {
//            call.enqueue(new Callback<String>() {
//                @Override
//                public void onResponse(Call<String> call, Response<String> response) {
////                    cancelLoadingDlg();
//                    if (response.code() == 200) {
//                        if (response.body() != null) {
//
//
//                            Log.d(TAG, "responceresponce1: " + response.body().toString());
//
//                            ToastView(response.body().toString());
//
////                            bundle.putString("MAIL_ADDRESS", mMailAddress);
//
//                            // Fragmentを生成し、setArgumentsで先ほどのbundleをセットする
////                            Fragment fragment = new UserRegistFragment();
////                            fragment.setArguments(bundle);
////                            LinearLayout layout = (LinearLayout) findViewById(R.id.layout_root);
////                            layout.removeAllViews();
////                            // FragmentをFragmentManagerにセットする
////                            getFragmentManager().beginTransaction()
////                                    .replace(R.id.layout_root, fragment, UserRegistFragment.TAG)
////                                    .commit();
//                        }
//                    } else if (response.code() == 401) {
//
//                        Log.d(TAG, "responceresponce2: " + response.body().toString());
//
////                        if (mRetryFlg) {
////                            _sp.resetLoginData();
////                            moveAct(LoginActivity.class);
////                        } else {
////                            apiUpdateTokens((ApiCallback) _activity, API_GET_COUPON_LISTS);
////                        }
//                    } else {
//
//                        Log.d(TAG, "responceresponce3: " + response.body().toString());
//
//                        if (response.code() == 400) {
//                            //複数項目のエラーメッセージが届くパターン
////                            String errorMessage = ErrorUtils.parseErrorFiled(response);
////                            ToastView(errorMessage);
//                        } else {
//                            //基本のエラーメッセージパターン
////                            APIError error = ErrorUtils.parseError(response);
////                            ToastView(error.message());
//                        }
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<String> call, Throwable t) {
//
//                    Log.d(TAG, "responceresponce4");
//
////                    cancelLoadingDlg();
////                    ToastView(getString(R.string.failure_api_message));
//                }
//            });
//        } catch (Exception e) {
//
//            Log.d(TAG, "responceresponce5");
//
//            //エラーメッセージなど
//            e.printStackTrace();
////            cancelLoadingDlg();
////            ToastView(getString(R.string.failure_api_message));
//        }
    }

    public void ToastView(String message) {
        if (message == null || "".equals(message)) return;
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

}
