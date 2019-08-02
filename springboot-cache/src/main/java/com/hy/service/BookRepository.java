package com.hy.service;

import com.hy.model.Book;

/**
 * @Author: wanghai
 * @Date:2019/6/29 22:27
 * @Copyright:reach-life
 * @Description:
 */
public interface BookRepository {

    Book getByIsbn(String isbn);

}
