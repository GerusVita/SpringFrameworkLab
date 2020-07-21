import {Component, OnInit} from '@angular/core';
import {Author} from '../author/author';
import {AuthorServiceService} from '../service/author-service.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-author-form',
  templateUrl: './author-form.component.html',
  styleUrls: ['./author-form.component.css']
})
export class AuthorFormComponent implements OnInit {
  public author: Author | null = null;

  constructor(public service: AuthorServiceService, public router: Router, private route: ActivatedRoute) {
  }

  save(): void {
    this.service.saveAuthor(this.author).subscribe(() =>
      this.router.navigate(['author']));
  }

  ngOnInit(): void {
    this.route.data.subscribe(({author}) => {
      this.author = !!author ? author : new Author();
    });
  }
}
