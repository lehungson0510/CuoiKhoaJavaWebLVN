import {Component, OnInit} from '@angular/core';
import {IBook} from "../../model/book/IBook";
import {BookService} from "../../service/book/book.service";
import {CategoryService} from "../../service/book/category.service";
import {Router} from "@angular/router";
import {ICategory} from "../../model/book/ICategory";
import {CartService} from "../../service/cart/cart.service";
import {NotifierService} from "angular-notifier";

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {
  bookList: IBook[] = [];
  categoryList: ICategory[] = [];
  scrollTop = 0;
  bookDelete: IBook = {};
  message: string = '';

  constructor(private bookService: BookService,
              private categoryService: CategoryService,
              private router: Router,
              private cartService: CartService,
              private notification: NotifierService,) {
  }

  ngOnInit(): void {
    this.getBookList();
    this.getCategory();
  }

  getBookList() {
    this.bookService.getBookList().subscribe(
      (data: any) => {
        this.bookList = data;
      }
    );
  }

  getCategory() {
    this.categoryService.getCategoryList().subscribe(
      (data: any) => {
        this.categoryList = data;
        console.log(data)
      }
    )
  }

  deleteForm(book: IBook) {
    this.bookDelete = book;
    console.log(book.bookId)
  }

  delete(id: any) {
    console.log(id)
    this.bookService.deleteBook(id).subscribe(() => {
      this.notification.notify('success','Xóa sách thành công')
      this.ngOnInit();
    })
  }

  searchName(name: any) {
    console.log(name.value)
    this.bookService.getBookByName(name).subscribe((data) => {
        this.bookList = data;
        if (data.length == 0) {
          this.message = 'Không tìm thấy'
        }
      }
    )
    this.message = '';
  }

  searchCategory(category : any) {
    const idCategorySearch = category.categoryId;
    this.bookService.getBookByCategory(idCategorySearch).subscribe((data) => {
        this.bookList = data;
        if (data.length == 0) {
          this.message = 'Không tìm thấy'
        }
      }
    )
    this.message = '';
  }

  addCart(book: IBook) {
    this.cartService.addOneBook(book).subscribe(()=>{
      this.notification.notify('success', 'Sách đã thêm vào Giỏ hàng');
    })
  }
}

