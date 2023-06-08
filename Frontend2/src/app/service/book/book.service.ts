import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {IBook} from "../../model/book/IBook";
import {Observable} from "rxjs"


// import {Observable} from "rxjs";
// import {Observable} from "rxjs/dist/types";

@Injectable({
  providedIn: 'root'
})
export class BookService {
  readonly API_URL = 'http://localhost:8080/api/book';

  constructor(private http: HttpClient) {
  }

  getBookList(){
    return this.http.get<Object[]>(this.API_URL + '/list');
  }

  getBookById(id: number): Observable<IBook> {
    return  this.http.get<IBook>(this.API_URL + '/detail/' + id);
  }

  getBookSameAuthor(idAuthor: number, idBook: number): Observable<IBook[]> {
    return this.http.get<IBook[]>(this.API_URL + '/same-author?idAuthor=' + idAuthor + '&idBook=' + idBook);
  }

  saveBook(book:IBook): Observable<void> {
    return this.http.post<void>(this.API_URL+'/create',book)
  }

  updateBook(book:IBook,id:number): Observable<void> {
    return this.http.patch<void>(this.API_URL+'/edit/'+id,book)
  }

  deleteBook(id : number):Observable<void> {
    return this.http.delete<void>(this.API_URL+'/delete/'+id)
  }

  getBookByName(name: string): Observable<IBook[]> {
    return this.http.get<IBook[]>(this.API_URL + '/find-book-by-name?name=' + name);
  }

  getBookByCategory(idCategory: number): Observable<IBook[]> {
    return this.http.get<IBook[]>(this.API_URL + '/find-book-by-category/' + idCategory);
  }
}
