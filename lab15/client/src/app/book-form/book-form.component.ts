import {Component, Input, OnInit} from '@angular/core';
import {Book} from '../book/book';
import {ActivatedRoute, Router} from '@angular/router';
import {BookServiceService} from '../service/book-service.service';
import {Genre} from '../genre/genre';
import {Author} from '../author/author';

@Component({
  selector: 'app-book-form',
  templateUrl: './book-form.component.html',
  styleUrls: ['./book-form.component.css']
})
export class BookFormComponent implements OnInit {
  public book: Book | null = null;
  public genre: Genre | null = null;
  public author: Author | null = null;

  constructor(public service: BookServiceService, public router: Router, private route: ActivatedRoute) {
  }

  save(): void {
    this.book.author = this.author;
    this.book.genre = this.genre;
    this.service.saveBook(this.book).subscribe(() =>
      this.router.navigate(['book']));
  }

  ngOnInit(): void {
    this.route.data.subscribe((value) => {
      console.log(value);
      if (!!value.book) {
        this.book = value.book;
        this.genre = this.book.genre;
        this.author = this.book.author;
      } else {
        this.book = new Book();
        this.genre = new Genre();
        this.author = new Author();
      }
    });
  }
}
