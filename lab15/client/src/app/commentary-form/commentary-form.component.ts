import {Component, Input, OnInit} from '@angular/core';
import {Commentary} from '../commentary/commentary';
import {Book} from '../book/book';
import {Reader} from '../reader/reader';
import {ActivatedRoute, Router} from '@angular/router';
import {Genre} from '../genre/genre';
import {Author} from '../author/author';
import {CommentaryServiceService} from '../service/commentary-service.service';

@Component({
  selector: 'app-commentary-form',
  templateUrl: './commentary-form.component.html',
  styleUrls: ['./commentary-form.component.css']
})
export class CommentaryFormComponent implements OnInit {
  public commentary: Commentary = new Commentary();
  @Input()
  public id: number;
  public book: Book;
  public reader: Reader = new Reader();

  constructor(public service: CommentaryServiceService, public router: Router, private route: ActivatedRoute) {
  }

  ngOnInit(): void {

    // this.route.data.subscribe((value) => {
    //   console.log(value);
    //   if (!!value.commentary) {
    //     this.commentary = value.commentary;
    //     this.book = this.commentary.book;
    //     this.reader = this.commentary.reader;
    //   } else {
    //     this.commentary = new Commentary();
    //     this.reader = new Reader();
    //     this.book = new Book();
    //   }
    // });
  }
    save(): void {
      this.commentary.reader = this.reader;
      this.commentary.book = new Book();
      this.commentary.book.id = this.id;
      this.service.saveComment(this.commentary).subscribe(() =>
        this.router.navigate(['book']));
    }
  }
