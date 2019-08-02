package com.hy.service.impl;

import com.hy.model.Book;
import com.hy.service.BookRepository;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @Author: wanghai
 * @Date:2019/6/29 22:28
 * @Copyright:reach-life
 * @Description:
 */
@Component
public class BookRepositoryImpl implements BookRepository{

    @Override
    @Cacheable(cacheNames = "books")
    public Book getByIsbn(String isbn) {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Book(isbn,isbn);
    }
}
