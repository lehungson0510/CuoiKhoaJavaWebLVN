package com.example.ckjvweb.service;

import com.example.ckjvweb.entity.book.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IBookService {
    List<Book> findAllBook();

    List<Book> findBookSlide();

    Optional<Book> findBookById(Integer id);

    List<Book> findBookSameAuthor(String author, Integer idBook);

    List<Book> findBookByCategory(Integer idCategory);

    List<Book> findBookByName(String name);

    List<Book> findBookBestSale();

    List<Book> findBookSaleSpecial();

    void editBook(String name, String img, String content, Double price, String translator, Integer totalPage, String size, LocalDate publishDate, Integer quantity, String publisher, Integer idCategory, String author, Integer promotion, Integer idBook);

    void createBook(String name, String img, String content, Double price, String translator, Integer totalPage, String size, LocalDate publishDate, Integer quantity, String publisher, Integer idCategory, String author, Integer promotion);

    void deleteBook(Integer id);

    List<Book> findBookBestSeller();

    void updateQuantityBook(Book bookId);
}
