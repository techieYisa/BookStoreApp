package com.qc.bookstoreapp;

import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by mohammadnaz on 1/3/18.
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookHolder>{
    List<Book> bookList;
    public clicklisten clicklisten;

    public BookAdapter(List<Book> bookList, clicklisten clicklisten){
        this.bookList=bookList;
        this.clicklisten=clicklisten;

    }

    public interface clicklisten{
        void clicked(int p);
    }

    @Override
    public BookHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent, false);
        return new BookHolder(view);
    }

    @Override
    public void onBindViewHolder(BookHolder holder, int position) {
        Book book= bookList.get(position);
        holder.onBind(book);

    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    class BookHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView title;
        TextView price;

        public BookHolder(View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.titleid);
            price= itemView.findViewById(R.id.priceid);
            itemView.setOnClickListener(this);

        }
        public void onBind(Book book){
            title.setText(book.getName());
            price.setText(String.valueOf(book.getPrice()));


        }

        @Override
        public void onClick(View v) {
            int p= getAdapterPosition();
            clicklisten.clicked(p);

        }


    }

}
