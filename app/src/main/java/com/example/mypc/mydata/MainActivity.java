package com.example.mypc.mydata;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView tv;
Uri uri=Uri.parse("content://muni.apssdc.in");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.textData);
    }

    public void retriveMydata(View view) {
        StringBuilder stringBuilder=new StringBuilder();
        Cursor cursor=getContentResolver()
                .query(uri,null,null,null,null);
        while (cursor.moveToNext()){
            stringBuilder.append(cursor.getString(0)+"\t");
            stringBuilder.append(cursor.getString(1)+"\t");
            stringBuilder.append(cursor.getString(2)+"\n");
        }
        tv.setText(stringBuilder);
    }
}
