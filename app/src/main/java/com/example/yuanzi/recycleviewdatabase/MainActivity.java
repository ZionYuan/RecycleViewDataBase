package com.example.yuanzi.recycleviewdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.yuanzi.recycleviewdatabase.table.Book;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    public List<Book> bookList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        recyclerview使用
         */
        initBooks();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        BookAdapter adapter = new BookAdapter(bookList);
        recyclerView.setAdapter(adapter);


//        Button createDatabase = (Button)findViewById(R.id.create_database);
//        createDatabase.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Connector.getDatabase();
//            }
//        });
//        Button adddata = (Button)findViewById(R.id.add_data);
//        adddata.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                for(int i = 0;i<10;i++){
//                    Book book = new Book();
//                    book.setAuthor("yuanzi");
//                    book.setName("yuanzi de book");
//                    book.setPages(340);
//                    book.setPress("unknow");
//                    book.setPrice(4000);
//                    book.save();
//                }
//
//
//            }
//        });
//        Button query = (Button)findViewById(R.id.query);
//        query.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                List<Book> bookList = DataSupport.findAll(Book.class);
//                for(Book book:bookList){
//                    Log.d("YZ_TAG",book.getId()+"");
//                    Log.d("YZ_TAG",book.getAuthor());
//                    Log.d("YZ_TAG",book.getName());
//                    Log.d("YZ_TAG",book.getPress());
//                    Log.d("YZ_TAG",book.getPages()+"");
//                    Log.d("YZ_TAG",book.getAuthor());
//                    Log.d("YZ_TAG","-------------------------");
//
//
//
//                }
//            }
//        });

    }
    private void initBooks(){
        List<Book> BookList = DataSupport.findAll(Book.class);
        for(Book book:BookList){
            bookList.add(book);
        }
    }

}
