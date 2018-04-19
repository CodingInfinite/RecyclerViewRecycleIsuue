package com.spartons.recyclerviewissueexample;

/**
 * Created by Ahsen Saeed on 19/04/2018.
 */

public class BookModel {

    private String bookName;
    private boolean wantToReadFlag;

    public BookModel(String bookName) {
        this.bookName = bookName;
        wantToReadFlag = false;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public boolean isWantToReadFlag() {
        return wantToReadFlag;
    }

    public void setWantToReadFlag(boolean wantToReadFlag) {
        this.wantToReadFlag = wantToReadFlag;
    }

    @Override
    public String toString() {
        return "BookModel{" +
                "bookName='" + bookName + '\'' +
                ", wantToReadFlag=" + wantToReadFlag +
                '}';
    }
}
