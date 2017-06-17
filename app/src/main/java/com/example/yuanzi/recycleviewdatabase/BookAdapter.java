package com.example.yuanzi.recycleviewdatabase;


import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuanzi.recycleviewdatabase.table.Book;

import java.util.List;

/**
 * Created by yuanzi on 2017/6/13.
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private List<Book> mBookList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        View bookView;
        TextView bookname;
        TextView bookauthor;

        public ViewHolder(View itemView) {
            super(itemView);
            bookView = itemView;
            bookname = (TextView)itemView.findViewById(R.id.book_name);
            bookauthor = (TextView) itemView.findViewById(R.id.book_author);
        }
    }
    public BookAdapter(List<Book> mBookList){
        this.mBookList = mBookList;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Book book = mBookList.get(position);
        holder.bookauthor.setText(book.getAuthor());
        holder.bookname.setText(book.getName());
    }

    @Override
    public int getItemCount() {
        return mBookList.size();
    }

    @Override
    public BookAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.bookView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int position = holder.getAdapterPosition();
                Book book = mBookList.get(position);
                Toast.makeText(v.getContext(),book.getName(),Toast.LENGTH_SHORT).show();
                AlertDialog.Builder dialog = new AlertDialog.Builder(v.getContext());
                dialog.setTitle("DIALOG");
                dialog.setMessage("是否删除此项数据?");
                dialog.setCancelable(false);

                dialog.setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mBookList.remove(position);
                        notifyItemRemoved(position);
                    }
                });
                dialog.setNegativeButton("否", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
            }
        });
        return holder;
    }
}
