import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Author} from '../author/author';

@Injectable({
  providedIn: 'root'
})
export class AuthorServiceService {
  private authorUrl: string;

  constructor(private http: HttpClient) {
    this.authorUrl = 'http://localhost:8080/api/author';
  }

  public findAll(): Observable<Author[]> {
    return this.http.get<Author[]>(this.authorUrl);
  }

  public updateAuthor(id: number): Observable<Author> {
    return this.http.get<Author>(this.authorUrl + '/' + id);
  }

  public saveAuthor(author: Author): Observable<any> {
    return this.http.post(this.authorUrl + '/save', author);
  }

  public deleteAuthor(id: number): Observable<any> {
   return  this.http.delete(`${this.authorUrl}/${id}/delete`);
  }
}
