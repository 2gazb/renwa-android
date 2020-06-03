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
import java.net.URLDecoder;
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
//        setContentView(R.layout.activity_main);
//        txvResult = (TextView) findViewById(R.id.txvResult);
        setContentView(R.layout.activity_camera);

        String fromWhere = "FROM_L";

        if (null == savedInstanceState) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, Camera2BasicFragment.newInstance(fromWhere))
                    .commit();
        }
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
//                    txvResult.setText(result.get(0));

                    sendAuthCode(result.get(0));

                    setContentView(R.layout.activity_done);
                    String fromWhere = "FROM_L";
//
//                    if (null == savedInstanceState) {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, Camera2BasicFragment.newInstance(fromWhere))
                                .commit();
//                    }

                }
                break;
        }
    }


    private void sendAuthCode(String authCode) {

        ToastView(authCode);

    }

    public void ToastView(String message) {
        if (message == null || "".equals(message)) return;
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

}
