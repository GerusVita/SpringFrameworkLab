import { Component, OnInit } from '@angular/core';
import {Genre} from '../genre/genre';
import {ActivatedRoute, Router} from '@angular/router';
import {GenreServiceService} from '../service/genre-service.service';

@Component({
  selector: 'app-genre-form',
  templateUrl: './genre-form.component.html',
  styleUrls: ['./genre-form.component.css']
})
export class GenreFormComponent implements OnInit {
  public genre: Genre | null = null;
  constructor(public service: GenreServiceService, public router: Router, private route: ActivatedRoute) { }

  save(): void {
    this.service.saveGenre(this.genre).subscribe(() =>
      this.router.navigate(['genre']));
  }

  ngOnInit(): void {
    this.route.data.subscribe(({genre}) => {
      this.genre = !!genre ? genre : new Genre();
    });
  }
}
