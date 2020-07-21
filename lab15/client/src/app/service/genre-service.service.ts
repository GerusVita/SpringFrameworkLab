import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Genre} from '../genre/genre';

@Injectable({
  providedIn: 'root'
})
export class GenreServiceService {
  private genreUrl: string;
  constructor(private http: HttpClient) { this.genreUrl = 'http://localhost:8080/api/genre'; }
  public findAll(): Observable<Genre[]> {
    return this.http.get<Genre[]>(this.genreUrl);
  }

  public updateGenre(id: number): Observable<Genre> {
    return this.http.get<Genre>(this.genreUrl + '/' + id);
  }

  public saveGenre(genre: Genre): Observable<any> {
    return this.http.post(this.genreUrl + '/save', genre);
  }

  public deleteGenre(id: number): Observable<any> {
    return this.http.delete(`${this.genreUrl}/${id}/delete`);
  }
}
