package com.example.moryta.demointent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends AppCompatActivity {

    @BindView(R.id.etUsername)
    EditText etUsername;

    @BindView(R.id.etName)
    EditText etName;

    @BindView(R.id.etPassword)
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btCreate)
    public void onCreateClick() {
        String username = etUsername.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("USERNAME", username);

        setResult(RESULT_OK, intent);
        finish();
    }
}
