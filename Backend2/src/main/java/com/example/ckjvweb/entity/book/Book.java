package com.example.ckjvweb.entity.book;

import com.example.ckjvweb.entity.cart.Cart;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer bookId;

    private String bookName;

    private String bookImage;

    private String bookContent;

    private Double bookPrice;

    private String bookTranslator;

    private Integer bookTotalPage;

    private String bookSize;

    private LocalDate bookPublishDate;

    private Integer bookQuantity = 0;

    private Boolean bookFlag = false;

    private String bookPublisher;

    private String bookAuthor;

    private Integer bookPromotion;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "book_category_id")
    private Category bookCategoryId;

    @OneToOne(mappedBy = "book")
    @JsonBackReference
    private Cart cart;

    public Book() {
    }

    public Book(Integer bookId, String bookName, String bookImage, String bookContent, Double bookPrice, String bookTranslator, Integer bookTotalPage, String bookSize, LocalDate bookPublishDate, Integer bookQuantity, Boolean bookFlag, String bookPublisher, String bookAuthor, Integer bookPromotion, Category bookCategoryId) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookImage = bookImage;
        this.bookContent = bookContent;
        this.bookPrice = bookPrice;
        this.bookTranslator = bookTranslator;
        this.bookTotalPage = bookTotalPage;
        this.bookSize = bookSize;
        this.bookPublishDate = bookPublishDate;
        this.bookQuantity = bookQuantity;
        this.bookFlag = bookFlag;
        this.bookPublisher = bookPublisher;
        this.bookAuthor = bookAuthor;
        this.bookPromotion = bookPromotion;
        this.bookCategoryId = bookCategoryId;
    }

    public Book(String bookName, String bookImage, String bookContent, Double bookPrice, String bookTranslator, Integer bookTotalPage, String bookSize, LocalDate bookPublishDate, Integer bookQuantity, String bookPublisher, String bookAuthor, Integer bookPromotion, Category bookCategoryId) {
        this.bookName = bookName;
        this.bookImage = bookImage;
        this.bookContent = bookContent;
        this.bookPrice = bookPrice;
        this.bookTranslator = bookTranslator;
        this.bookTotalPage = bookTotalPage;
        this.bookSize = bookSize;
        this.bookPublishDate = bookPublishDate;
        this.bookQuantity = bookQuantity;
        this.bookPublisher = bookPublisher;
        this.bookAuthor = bookAuthor;
        this.bookPromotion = bookPromotion;
        this.bookCategoryId = bookCategoryId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public String getBookContent() {
        return bookContent;
    }

    public void setBookContent(String bookContent) {
        this.bookContent = bookContent;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookTranslator() {
        return bookTranslator;
    }

    public void setBookTranslator(String bookTranslator) {
        this.bookTranslator = bookTranslator;
    }

    public Integer getBookTotalPage() {
        return bookTotalPage;
    }

    public void setBookTotalPage(Integer bookTotalPage) {
        this.bookTotalPage = bookTotalPage;
    }

    public String getBookSize() {
        return bookSize;
    }

    public void setBookSize(String bookSize) {
        this.bookSize = bookSize;
    }

    public LocalDate getBookPublishDate() {
        return bookPublishDate;
    }

    public void setBookPublishDate(LocalDate bookPublishDate) {
        this.bookPublishDate = bookPublishDate;
    }

    public Integer getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(Integer bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public Boolean getBookFlag() {
        return bookFlag;
    }

    public void setBookFlag(Boolean bookFlag) {
        this.bookFlag = bookFlag;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Integer getBookPromotion() {
        return bookPromotion;
    }

    public void setBookPromotion(Integer bookPromotion) {
        this.bookPromotion = bookPromotion;
    }

    public Category getBookCategoryId() {
        return bookCategoryId;
    }

    public void setBookCategoryId(Category bookCategoryId) {
        this.bookCategoryId = bookCategoryId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookImage='" + bookImage + '\'' +
                ", bookContent='" + bookContent + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookTranslator='" + bookTranslator + '\'' +
                ", bookTotalPage=" + bookTotalPage +
                ", bookSize='" + bookSize + '\'' +
                ", bookPublishDate=" + bookPublishDate +
                ", bookQuantity=" + bookQuantity +
                ", bookFlag=" + bookFlag +
                ", bookPublisher='" + bookPublisher + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPromotion=" + bookPromotion +
                ", bookCategoryId=" + bookCategoryId +
                ", cart=" + cart +
                '}';
    }
}
