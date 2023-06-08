import {Component, OnInit} from '@angular/core';
import {IBook} from "../../model/book/IBook";
import {ActivatedRoute, Router} from "@angular/router";
import {CategoryService} from "../../service/book/category.service";
import {BookService} from "../../service/book/book.service";
import {ICategory} from "../../model/book/ICategory";
import {FormBuilder, FormGroup} from "@angular/forms";
import {NotifierService} from "angular-notifier";

@Component({
  selector: 'app-book-edit',
  templateUrl: './book-edit.component.html',
  styleUrls: ['./book-edit.component.css']
})
export class BookEditComponent implements OnInit {
  categoryList: ICategory[] = [];
  book: IBook = {};
  idBook: number = 0;
  bookForm!: FormGroup;
  bookEdit: IBook = {};


  constructor(private activatedRoute: ActivatedRoute,
              private categoryService: CategoryService,
              private bookService: BookService,
              private fb: FormBuilder,
              private router: Router,
              private notification: NotifierService,) {
  }

  ngOnInit(): void {
    this.getCategory();
    this.activatedRoute.paramMap.subscribe((param) => {
        this.idBook = Number(param.get('id'));
        this.bookService.getBookById(this.idBook).subscribe(
          (data) => {
            this.bookEdit = data;
            this.bookForm = this.fb.group({
              bookName: [this.bookEdit.bookName],
              bookImage: [this.bookEdit.bookImage],
              bookContent: [this.bookEdit.bookContent],
              bookPrice: [this.bookEdit.bookPrice],
              bookTranslator: [this.bookEdit.bookTranslator],
              bookTotalPage: [this.bookEdit.bookTotalPage],
              bookSize: [this.bookEdit.bookSize],
              bookPublishDate: [this.bookEdit.bookPublishDate],
              bookQuantity: [this.bookEdit.bookQuantity],
              bookPublisher: [this.bookEdit.bookPublisher],
              bookCategoryId: [this.bookEdit.bookCategoryId],
              bookAuthor: [this.bookEdit.bookAuthor],
              bookPromotion: [this.bookEdit.bookPromotion],
            })
          }
        );
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

  submit(id: number) {
    const value = this.bookForm.value;
    console.log(value);
    this.bookService.updateBook(value, id).subscribe((data) => {
      alert('Cập nhật thành công');
      // this.notification.notify('success', 'Cập nhật thành công');
      this.router.navigateByUrl("/")
    })
  }

  compare(o1: ICategory, o2: ICategory) {
    if (o1 === null || o2 === null) {
      return false;
    }
    return o1.categoryId === o2.categoryId;
  }
}
