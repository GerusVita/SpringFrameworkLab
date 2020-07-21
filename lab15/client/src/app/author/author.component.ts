import {Component, OnInit} from '@angular/core';
import {Author} from './author';
import {AuthorServiceService} from '../service/author-service.service';
import {Observable} from 'rxjs';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.css']
})
export class AuthorComponent implements OnInit {
  public authors: Author[];

  constructor(public service: AuthorServiceService) {
  }

  ngOnInit(): void {
    this.service.findAll().subscribe(value => this.authors = value);
  }

  delete(id: number): void {
    this.service.deleteAuthor(id).subscribe(() => {
      this.ngOnInit();
    });
  }
}
