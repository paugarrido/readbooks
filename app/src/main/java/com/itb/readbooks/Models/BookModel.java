package com.itb.readbooks.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class BookModel implements Parcelable {

    private String name;
    private String author;
    private int rate;
    private int isRead;

    public BookModel(String name, String author, int rate, int isRead) {
        this.name = name;
        this.author = author;
        this.rate = rate;
        this.isRead = isRead;
    }

    protected BookModel(Parcel in) {
        name = in.readString();
        author = in.readString();
        rate = in.readInt();
        author = in.readString();
    }

    public static final Creator<BookModel> CREATOR = new Creator<BookModel>() {
        @Override
        public BookModel createFromParcel(Parcel in) {
            return new BookModel(in);
        }

        @Override
        public BookModel[] newArray(int size) {
            return new BookModel[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(author);
        dest.writeInt(rate);
        dest.writeInt(isRead);
    }
}
