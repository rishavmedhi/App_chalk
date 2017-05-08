package com.example.rmedhi.app_chalk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.example.rmedhi.app_chalk.api.Poll_service;
import com.example.rmedhi.app_chalk.fetch_api.Fetch_api;
import com.example.rmedhi.app_chalk.send_api.Send_api;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rl)
    RelativeLayout rlayout;

    @BindView(R.id.login_btn)
    Button login_btn;

    @BindView(R.id.sign_up_btn)
    Button sign_up_btn;

    @BindView(R.id.login_signup_action)
    Button log_action_btn;

    @BindView(R.id.email)
    EditText email_text;

    @BindView(R.id.password)
    EditText password_text;

    @BindView(R.id.retype_password)
    EditText retype_pass_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        email_text.setVisibility(rlayout.INVISIBLE);
        password_text.setVisibility(rlayout.INVISIBLE);
        retype_pass_text.setVisibility(rlayout.INVISIBLE);
        log_action_btn.setVisibility(rlayout.INVISIBLE);

        // setting up sign up btn action
        sign_up_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                sign_up_btn.setVisibility(rlayout.INVISIBLE);
                login_btn.setVisibility(rlayout.INVISIBLE);
                email_text.setVisibility(rlayout.VISIBLE);
                password_text.setVisibility(rlayout.VISIBLE);
                retype_pass_text.setVisibility(rlayout.VISIBLE);
                log_action_btn.setVisibility(rlayout.VISIBLE);

            }
        });

        // setting up login button action
        login_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                sign_up_btn.setVisibility(rlayout.INVISIBLE);
                login_btn.setVisibility(rlayout.INVISIBLE);
                email_text.setVisibility(rlayout.VISIBLE);
                password_text.setVisibility(rlayout.VISIBLE);
                log_action_btn.setVisibility(rlayout.VISIBLE);
            }
        });

        log_action_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                String user_email=email_text.getText().toString();
                String user_password=password_text.getText().toString();
                int flag=0;
                if (user_password.equals(retype_pass_text.getText().toString())==true)
                {
                    flag=user_signup(user_email,user_password);
                }
                Log.d("hello:",flag+"");
            }
        });
    }

    protected int user_signup(String user_email, String user_password)
    {
        Log.d("email",user_email);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://52.77.240.129/rishav/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Poll_service service = retrofit.create(Poll_service.class);

        Call<Fetch_api> fetch_obj = service.api_user_signup(user_email,user_password);
        fetch_obj.enqueue(new Callback<Fetch_api>() {
            @Override
            public void onResponse(Call<Fetch_api> call, Response<Fetch_api> response) {
                response.body(); // have your all data
                String uid =response.body().getUid();
                String status=response.body().getStatus();
            }

            @Override
            public void onFailure(Call<Fetch_api> call, Throwable t) {
                Log.d("failure",t.toString());
            }
        });
        return 1;
    }

}
