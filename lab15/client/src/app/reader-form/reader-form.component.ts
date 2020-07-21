import { Component, OnInit } from '@angular/core';
import {Author} from '../author/author';
import {Reader} from '../reader/reader';
import {ActivatedRoute, Router} from '@angular/router';
import {ReaderServiceService} from '../service/reader-service.service';

@Component({
  selector: 'app-reader-form',
  templateUrl: './reader-form.component.html',
  styleUrls: ['./reader-form.component.css']
})
export class ReaderFormComponent implements OnInit {
  public reader: Reader | null = null;

  constructor(public service: ReaderServiceService, public router: Router, private route: ActivatedRoute) { }

  save(): void {
    this.service.saveReader(this.reader).subscribe(() =>
      this.router.navigate(['reader']));
  }

  ngOnInit(): void {
    this.route.data.subscribe(({reader}) => {
      this.reader = !!reader ? reader : new Reader();
    });
  }

}
