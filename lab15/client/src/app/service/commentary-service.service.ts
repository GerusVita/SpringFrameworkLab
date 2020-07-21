import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Commentary} from '../commentary/commentary';

@Injectable({
  providedIn: 'root'
})
export class CommentaryServiceService {
  private commentUrl: string;

  constructor(private http: HttpClient) {
    this.commentUrl = 'http://localhost:8080/api/comment';
  }

  public findAll(): Observable<Commentary[]> {
    return this.http.get<Commentary[]>(this.commentUrl);
  }

  public updateComment(id: number): Observable<Commentary> {
    return this.http.get<Commentary>(this.commentUrl + '/' + id);
  }

  public saveComment(comment: Commentary): Observable<any> {
    return this.http.post(this.commentUrl + '/save', comment);
  }

  public deleteComment(id: number): Observable<any> {
    return this.http.delete(`${this.commentUrl}/${id}/delete`);
  }
}
