import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {BookListComponent} from "./book/book-list/book-list.component";
import {BookDetailComponent} from "./book/book-detail/book-detail.component";
import {BookCreateComponent} from "./book/book-create/book-create.component";
import {BookEditComponent} from "./book/book-edit/book-edit.component";
import {CartListComponent} from "./cart/cart-list/cart-list.component";

const routes: Routes = [
  {path:'', component: BookListComponent},
  {path:'detail/:id', component: BookDetailComponent},
  {path:'create', component: BookCreateComponent},
  {path:'update/:id', component: BookEditComponent},
  {path:'cart',component:CartListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
