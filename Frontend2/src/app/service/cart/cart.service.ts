import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ICart} from "../../model/cart/ICart";
import {IBook} from "../../model/book/IBook";

@Injectable({
  providedIn: 'root'
})
export class CartService {
  readonly API_URL = 'http://localhost:8080/api/cart';

  constructor(private http: HttpClient) {
  }

  getCartList():Observable<ICart[]>{
    return this.http.get<ICart[]>(this.API_URL + '/list');
  }

  addCart(cart:ICart):Observable<any> {
    return this.http.post<any>(this.API_URL,cart)
  }

  payment():Observable<any> {
    return this.http.delete<any>(this.API_URL+'/payment')
  }

  addOneBook(book : IBook):Observable<any> {
    return this.http.post<any>(this.API_URL+'/add-one-book',book)
  }

  changeQuantity(quantity:number, book:IBook):Observable<any> {
    return this.http.post<any>(this.API_URL+"/change-quantity/"+quantity,book)
  }

  deleteOneItem(cartId: number):Observable<any> {
    return this.http.delete<any>(this.API_URL+"/"+cartId)
  }
}
