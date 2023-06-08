import {IBook} from "../book/IBook";

export interface ICart {
  cartId?:number;
  cartQuantity?:number;
  cartTotalMoney?:number;
  book?:IBook;
}
