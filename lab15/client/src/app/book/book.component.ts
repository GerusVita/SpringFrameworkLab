import {Component, OnInit} from '@angular/core';
import {Book} from './book';
import {BookServiceService} from '../service/book-service.service';
import {ActivatedRoute} from '@angular/router';
import {Author} from '../author/author';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {
  public books: Book[] = [];

  constructor(public service: BookServiceService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.route.data.subscribe(({books}) => {
      console.log(books);
      this.books = !!books ? books : [];
    });
  }

  delete(id: number): void {
    this.service.deleteBook(id).subscribe(() => {
      this.service.findAll().subscribe(b => this.books = b);
    });
  }

}
