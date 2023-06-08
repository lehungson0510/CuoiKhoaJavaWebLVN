import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  readonly API_URL = 'http://localhost:8080/api/book';
  constructor(private http: HttpClient) { }

  getCategoryList(){
    return this.http.get<Object[]>(this.API_URL + '/category');
  }
}
