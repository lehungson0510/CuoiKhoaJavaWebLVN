import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {RouterModule} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import {HeaderComponent} from './layout/header/header.component';
import {FooterComponent} from './layout/footer/footer.component';
import {BookCreateComponent} from './book/book-create/book-create.component';
import {BookListComponent} from './book/book-list/book-list.component';
import {BookEditComponent} from './book/book-edit/book-edit.component';
import {BookDetailComponent} from './book/book-detail/book-detail.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { CartListComponent } from './cart/cart-list/cart-list.component';
import {NotifierModule} from "angular-notifier";

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    BookCreateComponent,
    BookListComponent,
    BookEditComponent,
    BookDetailComponent,
    CartListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    NotifierModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
