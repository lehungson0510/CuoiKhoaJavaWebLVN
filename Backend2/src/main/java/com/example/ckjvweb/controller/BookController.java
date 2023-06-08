package com.example.ckjvweb.controller;

import com.example.ckjvweb.entity.book.Book;
import com.example.ckjvweb.entity.book.Category;
import com.example.ckjvweb.service.IBookService;
import com.example.ckjvweb.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/book")
public class BookController {

    @Autowired
    IBookService bookService;

    @Autowired
    ICategoryService categoryService;

    @GetMapping("/list")
    public ResponseEntity<List<Book>> findAllBook() {
        List<Book> bookList = bookService.findAllBook();
        if (bookList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(bookList, HttpStatus.OK);
        }
    }

    @GetMapping("/slide")
    public ResponseEntity<List<Book>> findBookSlide() {
        List<Book> bookList = bookService.findBookSlide();
        if (bookList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(bookList, HttpStatus.OK);
        }
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable("id") Integer id) {
        Optional<Book> bookDetail = bookService.findBookById(id);
        if (!bookDetail.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(bookDetail.get(), HttpStatus.OK);
        }
    }

    @GetMapping("/same-author")
    public ResponseEntity<List<Book>> findBookSameAuthor(@RequestParam("author") String author, @RequestParam("idBook") Integer idBook) {
        List<Book> bookList = bookService.findBookSameAuthor(author, idBook);
//        if (bookList.isEmpty()) {
//            return new ResponseEntity<>(bookList, HttpStatus.NOT_FOUND);
//        } else {
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> findAllCategory() {
        List<Category> categoryList = categoryService.findAllCategory();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(categoryList, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(categoryList, HttpStatus.OK);
        }
    }

    @GetMapping("/find-book-by-category/{idCategory}")
    public ResponseEntity<List<Book>> findBookByCategory(@PathVariable("idCategory") Integer idCategory) {
        if (idCategory == 1) {
            List<Book> bookList = bookService.findAllBook();
            if (bookList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(bookList, HttpStatus.OK);
            }
        } else {
            List<Book> bookList = bookService.findBookByCategory(idCategory);
//            if (bookList.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            } else {
            return new ResponseEntity<>(bookList, HttpStatus.OK);
        }
    }

    @GetMapping("/find-book-by-name")
    public ResponseEntity<List<Book>> findBookByName(@RequestParam("name") String name) {
        List<Book> bookList;
        if (name == "") {
            bookList = bookService.findAllBook();
        } else {
            bookList = bookService.findBookByName(name);
//            if (bookList.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            } else {
        }
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @GetMapping("/best-sale")
    public ResponseEntity<List<Book>> findBookBestSale() {
        List<Book> bookList = bookService.findBookBestSale();
        if (bookList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(bookList, HttpStatus.OK);
        }
    }

    @GetMapping("/sale-special")
    public ResponseEntity<List<Book>> findBookSaleSpecial() {
        List<Book> bookList = bookService.findBookSaleSpecial();
        if (bookList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(bookList, HttpStatus.OK);
        }
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<?> editBook(@PathVariable("id") Integer id, @RequestBody Book book) {
        bookService.editBook(book.getBookName(), book.getBookImage(), book.getBookContent(), book.getBookPrice(), book.getBookTranslator(), book.getBookTotalPage(), book.getBookSize(), book.getBookPublishDate(), book.getBookQuantity(), book.getBookPublisher(), book.getBookCategoryId().getCategoryId(), book.getBookAuthor(), book.getBookPromotion(), id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createBook(@RequestBody Book book) {
        bookService.createBook(book.getBookName(), book.getBookImage(), book.getBookContent(), book.getBookPrice(), book.getBookTranslator(), book.getBookTotalPage(), book.getBookSize(), book.getBookPublishDate(), book.getBookQuantity(), book.getBookPublisher(), book.getBookCategoryId().getCategoryId(), book.getBookAuthor(), book.getBookPromotion());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Integer id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

