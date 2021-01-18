package com.itb.readbooks.Models;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class BookViewModel extends ViewModel {

    public List <BookModel> bookModelList = new ArrayList<>();

    public BookViewModel(){
        for (int i = 1; i <= 50; i++){
            bookModelList.add(new BookModel("Book" + i, "Author" + i, (int) (Math.random() * 11), (int) (Math.random() * 3)));
        }
    }
}
