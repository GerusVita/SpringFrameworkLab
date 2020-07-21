import {Author} from '../author/author';
import {Commentary} from '../commentary/commentary';
import {Genre} from '../genre/genre';

export class Book {
  public id: number;
  public title: string;
  public author: Author;
  public genre: Genre;
  public comments: Commentary[] = [];
}
