package com.itb.readbooks.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.itb.readbooks.Adapters.BookAdapter;
import com.itb.readbooks.Models.BookModel;
import com.itb.readbooks.Models.BookViewModel;
import com.itb.readbooks.R;

public class BookListFragment extends Fragment {

    RecyclerView recyclerView;
    BookViewModel bookViewModel;
    Button add_button;
    RatingBar ratingBar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bookViewModel = new ViewModelProvider(this).get(BookViewModel.class);
        if (getArguments() != null){
            int position = (int) requireArguments().get("BookModelEditPosition");
            if (position < 0){
                bookViewModel.bookModelList.add((BookModel) requireArguments().get("BookModel"));
            }else {
                bookViewModel.bookModelList.set(position, (BookModel) requireArguments().get("BookModelEdit"));
            }
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.book_list_fragment, container, false);

        BookAdapter adapter = new BookAdapter(bookViewModel.bookModelList, new BookAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BookModel missingStudent, int position) {
                NavDirections listToDetailDirections = BookListFragmentDirections.actionBookListFragmentToBookFragmentEdit(bookViewModel.bookModelList.get(position), position);
                Navigation.findNavController(v).navigate(listToDetailDirections);
            }
        });

        ratingBar = v.findViewById(R.id.rate);
        add_button = v.findViewById(R.id.add_button_list);
        recyclerView = v.findViewById(R.id.recycleview);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections listToDetailDirections = BookListFragmentDirections.actionBookListFragmentToBookFragment();
                Navigation.findNavController(v).navigate(listToDetailDirections);
            }
        });

        return v;
    }

}
