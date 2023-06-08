import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {BookService} from "../../service/book/book.service";
import {IBook} from "../../model/book/IBook";
import {CartService} from "../../service/cart/cart.service";
import {NotifierService} from "angular-notifier";

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.css']
})
export class BookDetailComponent implements OnInit {
  idBook: number = 0;
  bookDetail: IBook = {
  };


  constructor(private activatedRoute: ActivatedRoute,
              private bookService: BookService,
              private cartService : CartService,
              private notification:NotifierService) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((param) => {
        this.idBook = Number(param.get('id'));
        this.bookService.getBookById(this.idBook).subscribe((data) =>{
          this.bookDetail = data;
        })
      }
    )
  }

  addCart(book: IBook) {
    this.cartService.addOneBook(book).subscribe(()=>{
      this.notification.notify('success','Sách đã thêm vào giỏ hàng')
    })
  }
}
