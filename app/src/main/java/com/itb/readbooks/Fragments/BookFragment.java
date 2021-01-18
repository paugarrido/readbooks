package com.itb.readbooks.Fragments;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.itb.readbooks.Models.BookModel;
import com.itb.readbooks.R;

import java.util.Objects;

public class BookFragment extends Fragment {

    EditText editTextName;
    EditText editTextAuthor;
    Spinner spinnerIsRead;
    RatingBar ratingBarRate;

    Button add_new_button;

    BookModel book;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.book_fragment, container, false);
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editTextName = view.findViewById(R.id.editTextName);
        editTextAuthor = view.findViewById(R.id.editTextAuthor);
        spinnerIsRead = view.findViewById(R.id.spinnerIsRead);
        ratingBarRate = view.findViewById(R.id.ratingBarRate);
        add_new_button = view.findViewById(R.id.button_add);

        add_new_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                book = new BookModel(editTextName.getText().toString(), editTextAuthor.getText().toString(), spinnerIsRead.getSelectedItemPosition(), ratingBarRate.getProgress());

                NavDirections listToDetailDirections = BookFragmentDirections.actionBookFragmentToBookListFragment(book, -1);
                Navigation.findNavController(v).navigate(listToDetailDirections);
            }
        });

    }
}
