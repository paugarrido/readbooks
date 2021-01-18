package com.itb.readbooks.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.itb.readbooks.Models.BookModel;
import com.itb.readbooks.R;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookHolder> {

    private List<BookModel> books;
    private OnItemClickListener itemClickListener;

    public interface  OnItemClickListener {
        void onItemClick(BookModel book, int position);
    }

    public BookAdapter(List<BookModel> books, OnItemClickListener itemClickListener) {
        this.books = books;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public BookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_list_item, parent, false);
        return new BookHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BookHolder holder, int position) {
        holder.bind(books.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }


    public static class BookHolder extends RecyclerView.ViewHolder{
        private TextView name, author, isRead;
        private RatingBar rate;

        public void bind(final BookModel book, final OnItemClickListener listener) {
            name.setText(book.getName());
            author.setText(book.getAuthor());
            rate.setProgress(book.getRate());

            if (book.getIsRead() == 0){
                isRead.setText("NO READ");
            }
            if (book.getIsRead() == 1){
                isRead.setText("READING");
            }
            if (book.getIsRead() == 2){
                isRead.setText("READ");
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(book, getAdapterPosition());
                }
            });
        }

        public BookHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            author = itemView.findViewById(R.id.author);
            isRead = itemView.findViewById(R.id.isRead);
            rate = itemView.findViewById(R.id.rate);
        }

    }
}

