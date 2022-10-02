package com.example.demo.controller;

import com.example.demo.dto.BookEntity;
import com.example.demo.dto.ESBook;
import com.example.demo.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author geng
 * 2020/12/20
 */
@Slf4j
@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * 添加book，这里我直接使用了Entity，为了演示有点不规范！
     */
    @PostMapping("/book")
    public Map<String, String> addBook(@RequestBody BookEntity ESBook) {
        bookService.addBook(ESBook);
        Map<String, String> map = new HashMap<>();
        map.put("msg", "ok");
        return map;
    }

    /**
     * 从ES中搜索
     */
    @GetMapping("/book/search/es")
    public List<ESBook> searchES(String key) {
        return bookService.search(key);
    }

    @GetMapping("/book/search")
    public SearchHits<ESBook> search(String key) {
        return bookService.searchBookTitle(key);
    }

    @GetMapping("/book/search/mysql")
    public List<BookEntity> test(String key) {
        log.info("key = {}", key);
        return bookService.searchBookFromMysql(key);
    }
}