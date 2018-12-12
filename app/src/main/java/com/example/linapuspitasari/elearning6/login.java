package com.example.lenovo.e_learning;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lenovo.e_learning.apihelper.BaseApiService;
import com.example.lenovo.e_learning.apihelper.UtilsApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity {
    EditText username,password;
    Button btnLogin;
    ProgressDialog loading;


    BaseApiService mApiService;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Login");
        setContentView(R.layout.activity_login);

        mContext = this;


        SharePrefManager sharePrefManager = new SharePrefManager(this);

        if (sharePrefManager.getSPSudahLogin()){
            Intent baruIntent = new Intent(login.this, MainActivity.class);
            startActivity(baruIntent);
//            startActivity(new Intent(LoginActivity.this, Home.class)
//                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }

        mApiService = UtilsApi.getAPIService();
        initComponents();
    }

    private void initComponents() {
        username = findViewById(R.id.textView26);
        password = findViewById(R.id.textView27);
        btnLogin = findViewById(R.id.button12);

        btnLogin.setOnClickListener(v -> {

            loading = ProgressDialog.show(mContext, null, "Harap tunggu...", true, false);
            requestLogin();

        });
    }

    private void requestLogin() {
        SharePrefManager sharePrefManager = new SharePrefManager(this);
        String uname = username.getText().toString();
        String pass = password.getText().toString();

        mApiService.loginRequest(uname, pass)
                .enqueue(new Callback<ResponseBody>() {
                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void onResponse(@NonNull Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            loading.dismiss();i
                            try {
                                JSONObject jsonResult = new JSONObject(Objects.requireNonNull(response.body()).string());
                                if (jsonResult.getString("error").equals("false")){
                                    sharePrefManager.saveSPString(SharePrefManager.SP_EMAIL, uname);
                                    sharePrefManager.saveSPString(SharePrefManager.SP_NAMA, "Nama Mhs Coba");
                                    sharePrefManager.saveSPBoolean(SharePrefManager.SP_SUDAH_LOGIN, true);
                                    Intent intent=new Intent(login.this,MainActivity.class);
                                    startActivity(intent);
                                    finish();


                                } else {
                                    String error_message = jsonResult.getString("error_msg");
                                    Toast.makeText(login.this, error_message, Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            loading.dismiss();
                            Toast.makeText(login.this, "error message", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.toString());
                        loading.dismiss();
                        Toast.makeText(login.this,"koneksi bermasalah", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
