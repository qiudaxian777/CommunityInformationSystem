package com.example.yt.communityinformationsystem;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MyHelper myHelper;
    private EditText edtTxtName;
    private EditText edtTxtId;
    private TextView tvShow;
    private Button btnAdd;
    private Button btnQuery;
    private Button btnUpdate;
    private Button btnDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myHelper=new MyHelper(this);
        init();
    }
    private void init() {
        edtTxtName=(EditText) findViewById(R.id.edtTxt_main_name);
        edtTxtId=(EditText) findViewById(R.id.edtTxt_main_id);
        tvShow=(TextView)findViewById(R.id.tv_main_show);
        btnAdd=(Button)findViewById(R.id.btn_main_add);
        btnQuery=(Button)findViewById(R.id.btn_main_query);
        btnUpdate=(Button)findViewById(R.id.btn_main_update);
        btnDelete=(Button)findViewById(R.id.btn_main_delete);
        btnAdd.setOnClickListener(this);
        btnQuery.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String name;
        String id;
        SQLiteDatabase db;
        ContentValues values;
        switch (view.getId()){
            case R.id.btn_main_add:
                name=edtTxtName.getText().toString();
                id=edtTxtId.getText().toString();
                db=myHelper.getWritableDatabase();
                values=new ContentValues();
                values.put("name",name);
                values.put("id",id);
                db.insert("information",null,values);
                Toast.makeText(this,"社团信息已添加",Toast.LENGTH_LONG).show();
                db.close();;
                break;
            case R.id.btn_main_query:
                db = myHelper.getReadableDatabase();
                Cursor cursor=db.query("information",null,null,null,null,null,null);
                if (cursor.getCount()==0){
                    tvShow.setText("");
                    Toast.makeText(this,"没有此社团信息",Toast.LENGTH_LONG).show();
                } else {
                    cursor.moveToFirst();
                    tvShow.setText("Name :"+cursor.getString(1)+"; ID :"+cursor.getString(2));
                }
                while (cursor.moveToNext()){
                    tvShow.append("\n"+"Name :"+cursor.getString(1)+" ; ID :"+cursor.getString(2));
                }
                cursor.close();
                db.close();
                break;
            case R.id.btn_main_update:
                db=myHelper.getWritableDatabase();
                values=new ContentValues();
                values.put("id",id=edtTxtId.getText().toString());
                db.update("information",values,"name=?",new String[]{edtTxtName.getText().toString()});
                Toast.makeText(this,"社团信息已修改",Toast.LENGTH_LONG).show();
                db.close();
                break;
            case R.id.btn_main_delete:
                db=myHelper.getWritableDatabase();
                db.delete("information",null,null);
                Toast.makeText(this,"社团信息已删除",Toast.LENGTH_LONG).show();
                tvShow.setText("");
                db.close();
                break;

        }
    }
}
