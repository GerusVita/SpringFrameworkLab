import { Component, OnInit } from '@angular/core';
import {Reader} from './reader';
import {ReaderServiceService} from '../service/reader-service.service';

@Component({
  selector: 'app-reader',
  templateUrl: './reader.component.html',
  styleUrls: ['./reader.component.css']
})
export class ReaderComponent implements OnInit {
  public readers: Reader[];
  constructor(public service: ReaderServiceService) { }

  ngOnInit(): void {
    this.service.findAll().subscribe(value => this.readers = value);
  }

  delete(id: number): void {
    this.service.deleteReader(id).subscribe(() => {
      this.ngOnInit();
    });
  }

}
