import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Book} from '../book/book';

@Injectable({
  providedIn: 'root'
})
export class BookServiceService {
  private bookUrl: string;

  constructor(private http: HttpClient) {
    this.bookUrl = 'http://localhost:8080/api/book';
  }

  public findAll(): Observable<Book[]> {
    return this.http.get<Book[]>(this.bookUrl);
  }
  public findAllByGenre(id: number): Observable<Book[]> {
    return this.http.get<Book[]>(`${this.bookUrl}/genre/${id}`);
  }
  public updateBook(id: number): Observable<Book> {
    return this.http.get<Book>(this.bookUrl + '/' + id);
  }

  public saveBook(book: Book): Observable<any> {
    return this.http.post(this.bookUrl + '/save', book);
  }

  public deleteBook(id: number): Observable<any> {
    return this.http.delete(`${this.bookUrl}/${id}/delete`);
  }
}
