package com.example.rmedhi.app_chalk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

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
    }
}
