import {Book} from '../book/book';
import {Reader} from '../reader/reader';

export class Commentary {
  public id: number;
  public text: string;
  public book: Book;
  public reader: Reader;
}
