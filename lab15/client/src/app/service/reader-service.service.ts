import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Reader} from '../reader/reader';

@Injectable({
  providedIn: 'root'
})
export class ReaderServiceService {
  private readerUrl: string;
  constructor(private http: HttpClient) {this.readerUrl = 'http://localhost:8080/api/reader'; }
  public findAll(): Observable<Reader[]> {
    return this.http.get<Reader[]>(this.readerUrl);
  }

  public updateReader(id: number): Observable<Reader> {
    return this.http.get<Reader>(this.readerUrl + '/' + id);
  }

  public saveReader(reader: Reader): Observable<any> {
    return this.http.post(this.readerUrl + '/save', reader);
  }

  public deleteReader(id: number): Observable<any> {
    return this.http.delete(`${this.readerUrl}/${id}/delete`);
  }
}
