import {Component, OnInit} from '@angular/core';
import {Genre} from './genre';
import {GenreServiceService} from '../service/genre-service.service';

@Component({
  selector: 'app-genre',
  templateUrl: './genre.component.html',
  styleUrls: ['./genre.component.css']
})
export class GenreComponent implements OnInit {
  public genres: Genre[];

  constructor(public service: GenreServiceService) {
  }

  ngOnInit(): void {
    this.service.findAll().subscribe(value => this.genres = value);
  }

  delete(id: number): void {
    this.service.deleteGenre(id).subscribe(() => {
      this.ngOnInit();
    });
  }

}
