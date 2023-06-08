import {Component, OnInit} from '@angular/core';
import {ICart} from "../../model/cart/ICart";
import {Router} from "@angular/router";
import {CartService} from "../../service/cart/cart.service";
import {IBook} from "../../model/book/IBook";
import {NotifierService} from "angular-notifier";

@Component({
  selector: 'app-cart-list',
  templateUrl: './cart-list.component.html',
  styleUrls: ['./cart-list.component.css']
})
export class CartListComponent implements OnInit {
  cartList: ICart[] = []
  totalPrice: number = 0;
  defaultQuantity: number = 1;
  bookDelete: IBook = {};

  constructor(private router: Router,
              private cartService: CartService,
              private notification: NotifierService) {
  }

  ngOnInit(): void {
    this.getCartList();
  }

  getCartList() {
    this.totalPrice = 0;
    this.cartService.getCartList().subscribe((data) => {
      this.cartList = data;
      for (let i = 0; i < data.length; i++) {
        this.totalPrice += data[i].cartTotalMoney!
      }
    })
  }

  addOneBook(book: IBook) {
    this.cartService.addOneBook(book).subscribe(() => {
    })
  }

  // delete(bookId : number) {
  //     this.cartService.deleteOneItem().subscribe
  // }

  changeQuantity(quantity: any, book: IBook) {
    const qtt = Number(quantity);
    if (qtt <= 0 ) {
      this.bookDelete = book;
      document.getElementById('delete')?.click();
    }
    this.cartService.changeQuantity(qtt, book).subscribe(() => {
      this.getCartList();
    })
  }

  payment() {
    this.cartService.payment().subscribe(() => {
        this.getCartList();
        this.notification.notify('success', 'Thanh toán thành công');
      }
    )
  }


}
