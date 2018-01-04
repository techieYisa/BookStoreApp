package com.qc.bookstoreapp;

import android.content.Intent;
import android.content.ReceiverCallNotAllowedException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.qc.bookstoreapp.RetroFit70s.BookService;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements BookAdapter.clicklisten{
    private static final String TAG = "food";
    RecyclerView recyclerView;
LinearLayoutManager linearLayoutManager;
List<Book> bookList;
BookService bookService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        linearLayoutManager= new LinearLayoutManager(getApplicationContext());
        try {
            getstuff();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getstuff() throws IOException {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


      bookService= retrofit.create(BookService.class);//makes the interface come to life for the retrofit to use
        Call<List<Book>> call=bookService.getBook();///adds to a call list

        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                bookList=response.body();
                BookAdapter bookAdapter= new BookAdapter(bookList, MainActivity.this);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(bookAdapter);
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {

            }
        });

    }

    @Override
    public void clicked(int p) {
        Intent intent = new Intent(MainActivity.this, BookDetail.class);
        Book book= bookList.get(p);
        intent.putExtra("name", book.getName());
        intent.putExtra("price", String.valueOf(book.getPrice()));
        Log.e(TAG,"intent clicked");
        startActivity(intent);



    }
}
