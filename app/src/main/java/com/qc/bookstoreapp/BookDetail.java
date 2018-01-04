package com.qc.bookstoreapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class BookDetail extends AppCompatActivity {
    private static final String TAG = "detail activity";
    TextView name1;
TextView price1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        name1=findViewById(R.id.name1);
        price1=findViewById(R.id.price1);
        Intent intent=getIntent();
        String name= intent.getStringExtra("name");
        String price=intent.getStringExtra("price");
        Log.e(TAG,name);
        Log.e(TAG,price);

        name1.setText(name);
        price1.setText(price);

    }
}
