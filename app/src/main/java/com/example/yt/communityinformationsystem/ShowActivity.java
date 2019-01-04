package com.example.yt.communityinformationsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {
    private TextView tvName;
    private TextView tvPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        String password=intent.getStringExtra("password");
        tvName =(TextView)findViewById(R.id.tv_show_name);
        tvPassword=(TextView)findViewById(R.id.tv_show_password);
        tvName.setText("用户名："+ name);
        tvPassword.setText("密     码："+ password);
    }
}
