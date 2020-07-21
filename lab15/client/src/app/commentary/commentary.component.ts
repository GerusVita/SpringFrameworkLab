import { Component, OnInit } from '@angular/core';
import {Commentary} from './commentary';
import {CommentaryServiceService} from '../service/commentary-service.service';

@Component({
  selector: 'app-commentary',
  templateUrl: './commentary.component.html',
  styleUrls: ['./commentary.component.css']
})
export class CommentaryComponent implements OnInit {
  public commentaries: Commentary[];
  constructor(public service: CommentaryServiceService) { }

  ngOnInit(): void {
    this.service.findAll().subscribe(value => this.commentaries = value);
  }

  delete(id: number): void {
    this.service.deleteComment(id).subscribe(() => {
      this.ngOnInit();
    });
  }

}
