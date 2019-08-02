package com.hy.util.runner;

import com.hy.service.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Author: wanghai
 * @Date:2019/6/29 22:31
 * @Copyright:reach-life
 * @Description:
 */
@Component
public class BookCommandLineRunner  implements CommandLineRunner{

    private final static Logger logger = LoggerFactory.getLogger(BookCommandLineRunner.class);


    private final BookRepository bookRepository;

    public BookCommandLineRunner(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        logger.info(bookRepository.getByIsbn("aa").toString());
        logger.info(bookRepository.getByIsbn("bb").toString());
        logger.info(bookRepository.getByIsbn("bb").toString());
        logger.info(bookRepository.getByIsbn("aa").toString());
        logger.info(bookRepository.getByIsbn("bb").toString());
        logger.info(bookRepository.getByIsbn("aa").toString());
    }
}
