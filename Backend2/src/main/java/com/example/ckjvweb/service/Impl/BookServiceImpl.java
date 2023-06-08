package com.example.ckjvweb.service.Impl;

import com.example.ckjvweb.entity.book.Book;
import com.example.ckjvweb.repository.IBookRepository;
import com.example.ckjvweb.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    IBookRepository bookRepository;

    @Override
    public List<Book> findAllBook() {
        return bookRepository.findBookList();
    }

    @Override
    public List<Book> findBookSlide() {
        return bookRepository.findBookSlide();
    }

    @Override
    public Optional<Book> findBookById(Integer id) {
        return bookRepository.findBookById(id);
    }

    @Override
    public List<Book> findBookSameAuthor(String author, Integer idBook) {
        return bookRepository.findBookSameAuthor(author, idBook);
    }

    @Override
    public List<Book> findBookByCategory(Integer idCategory) {
        return bookRepository.findBookByCategory(idCategory);
    }

    @Override
    public List<Book> findBookByName(String name) {
        return bookRepository.findBookByName('%'+name+'%');
    }

    @Override
    public List<Book> findBookBestSale() {
        return bookRepository.findBookBestSale();
    }

    @Override
    public List<Book> findBookSaleSpecial() {
        return bookRepository.findBookSaleSpecial();
    }

    @Override
    public void editBook(String name, String img, String content, Double price, String translator, Integer totalPage, String size, LocalDate publishDate, Integer quantity, String publisher, Integer idCategory, String author, Integer promotion, Integer idBook) {
        bookRepository.editBook(name, img, content, price, translator, totalPage, size, publishDate, quantity, publisher,idCategory, author, promotion,idBook);
    }

    @Override
    public void createBook(String name, String img, String content, Double price, String translator, Integer totalPage, String size, LocalDate publishDate, Integer quantity, String publisher, Integer idCategory, String author, Integer promotion) {
        bookRepository.createBook(name,img, content,price,translator,totalPage,size,publishDate,quantity,publisher,idCategory,author,promotion);
    }

    @Override
    public void deleteBook(Integer id) {
        bookRepository.deleteBook(id);
    }

    @Override
    public List<Book> findBookBestSeller() {
        return bookRepository.findBookBestSeller();
    }

    @Override
    public void updateQuantityBook(Book bookId) {
        bookRepository.save(bookId);
    }
}
