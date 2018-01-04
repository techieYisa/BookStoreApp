package com.qc.bookstoreapp.RetroFit70s;

import com.qc.bookstoreapp.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mohammadnaz on 1/3/18.
 */

public interface BookService {
    @GET("tamingtext/book/master/apache-solr/example/exampledocs/books.json")
    Call<List<Book>> getBook();


}
