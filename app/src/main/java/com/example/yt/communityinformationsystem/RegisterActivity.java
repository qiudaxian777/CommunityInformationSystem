package com.example.yt.communityinformationsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    private EditText edtTxtName;
    private EditText edtTxtPassword;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edtTxtName=findViewById(R.id.edtTxt_regist_name);
        edtTxtPassword=findViewById(R.id.edtTxt_regist_password);
        btnSend=findViewById(R.id.btn_regist_send);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passDate();
            }
        });
    }
    public void passDate(){
        Intent intent=new Intent(this,ShowActivity.class);
        intent.putExtra("name",edtTxtName.getText().toString().trim());
        intent.putExtra("password",edtTxtPassword.getText().toString().trim());
        startActivity(intent);
    }
}
