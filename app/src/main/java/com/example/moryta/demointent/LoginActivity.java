package com.example.moryta.demointent;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    public static final int REQUEST_SIGN_UP = 1;

    @BindView(R.id.etUsername)
    EditText etUsername;

    @BindView(R.id.etPassword)
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        if (savedInstanceState != null) {
            etUsername.setText(savedInstanceState.getString("USERNAME"));
        }
    }

    @OnClick(R.id.btSignIn)
    public void onSignInClick() {

    }

    @OnClick(R.id.tvSignUp)
    public void onSignUpClick() {
        Intent newUser = new Intent(this, SignUpActivity.class);
        startActivityForResult(newUser, REQUEST_SIGN_UP);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQUEST_SIGN_UP:
                etUsername.setText(data.getStringExtra("USERNAME"));
            break;
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        outState.putString("TEXTO", etUsername.getText().toString());
    }
}
