import {ICategory} from "./ICategory";

export interface IBook {
  bookId?: number;
  bookName?: string;
  bookImage?: string;
  bookContent?: string;
  bookPrice?: number;
  bookTranslator?: string;
  bookTotalPage?: number;
  bookSize?: string;
  bookPublishDate?: string;
  bookQuantity?: number;
  bookFlag?: boolean;
  bookPublisher?: string;
  bookCategoryId?: ICategory;
  bookAuthor?: string;
  bookPromotion?: number;
}
