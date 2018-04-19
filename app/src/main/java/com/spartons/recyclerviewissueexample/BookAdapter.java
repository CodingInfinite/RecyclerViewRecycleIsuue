package com.spartons.recyclerviewissueexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ahsen Saeed on 19/04/2018.
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyViewHolder> {

    private final LayoutInflater layoutInflater;
    private List<BookModel> bookModels;

    public BookAdapter(List<BookModel> bookModels, final Context context) {
        this.bookModels = bookModels;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public BookAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(layoutInflater.inflate(R.layout.book_single_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapter.MyViewHolder holder, int position) {
        BookModel bookModel = bookModels.get(position);
        holder.bookNameTextView.setText(bookModel.getBookName());
        if (bookModel.isWantToReadFlag())
            holder.wantToReadCheckBox.setChecked(true);
        else
            bookModel.setWantToReadFlag(false);
        holder.setICheckChangeListener(new ICheckChangeListener() {
            @Override
            public void onItemChecked(int position, boolean value) {
                bookModels.get(position).setWantToReadFlag(value);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bookModels.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView bookNameTextView;
        private CheckBox wantToReadCheckBox;
        private ICheckChangeListener iCheckChangeListener;

        private MyViewHolder(View itemView) {
            super(itemView);
            bookNameTextView = itemView.findViewById(R.id.bookNameTextView);
            wantToReadCheckBox = itemView.findViewById(R.id.wantToReadCheckBox);
            wantToReadCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    iCheckChangeListener.onItemChecked(getAdapterPosition(), b);
                }
            });
        }

        void setICheckChangeListener(ICheckChangeListener iCheckChangeListener) {
            this.iCheckChangeListener = iCheckChangeListener;
        }
    }
}
