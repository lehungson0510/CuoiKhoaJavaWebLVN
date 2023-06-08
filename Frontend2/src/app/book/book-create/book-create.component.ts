import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {BookService} from "../../service/book/book.service";
import {Router} from "@angular/router";
import {ICategory} from "../../model/book/ICategory";
import {CategoryService} from "../../service/book/category.service";
import {NotifierService} from "angular-notifier";

@Component({
  selector: 'app-book-create',
  templateUrl: './book-create.component.html',
  styleUrls: ['./book-create.component.css']
})
export class BookCreateComponent implements OnInit{
bookForm!: FormGroup;
categoryList: ICategory[] = [];
constructor(private bookService: BookService,
            private router: Router,
            private fb: FormBuilder,
            private categoryService:CategoryService,
            private notification: NotifierService,) {
}

  ngOnInit(): void {
  this.getCategory();
   this.bookForm = this.fb.group({
     bookName : ['',Validators.required],
     bookImage:['',Validators.required],
     bookContent:['',Validators.required],
     bookPrice: ['',Validators.required, Validators.min(0)],
     bookTranslator: [''],
     bookTotalPage:['',Validators.required,Validators.min(1)] ,
     bookSize:['',Validators.required] ,
     bookPublishDate:['',Validators.required] ,
     bookQuantity:['',Validators.required,Validators.min(1)] ,
     bookPublisher:['',Validators.required] ,
     bookCategoryId:['',Validators.required] ,
     bookAuthor:['',Validators.required],
     bookPromotion: ['',Validators.required],
   })
  }

  submit() {
    const  value = this.bookForm.value;
    this.bookService.saveBook(value).subscribe((data) => {
      // this.notification.notify('success', 'Thêm mới thành công');
      this.router.navigateByUrl("/")
    })
  }

  getCategory(){
    this.categoryService.getCategoryList().subscribe(
      (data: any) => {
        this.categoryList = data;
        console.log(data)
      }
    )
  }
}
