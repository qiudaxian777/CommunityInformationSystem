package com.example.yt.communityinformationsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {
    private TextView tvName;
    private TextView tvPassword;
    private Button btnEnter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        String password=intent.getStringExtra("password");
        tvName =findViewById(R.id.tv_show_name);
        tvPassword=findViewById(R.id.tv_show_password);
        tvName.setText("用户名："+ name);
        tvPassword.setText("密     码："+ password);
        btnEnter=findViewById(R.id.btn_show_enter);
        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passDate();
            }
        });
    }
    public void passDate(){
        Intent  intent1=new Intent(this,MainActivity.class);
        startActivity(intent1);
    }
}
