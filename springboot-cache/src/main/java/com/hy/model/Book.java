package com.hy.model;

import java.io.Serializable;

/**
 * @Author: wanghai
 * @Date:2019/6/29 22:25
 * @Copyright:reach-life
 * @Description:
 */
public class Book implements Serializable{

    private String isbn;

    private String title;

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
