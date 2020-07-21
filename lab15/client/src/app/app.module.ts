import {BrowserModule} from '@angular/platform-browser';
import {Injectable, NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {HttpClientModule} from '@angular/common/http';
import {AuthorComponent} from './author/author.component';
import {BookComponent} from './book/book.component';
import {CommentaryComponent} from './commentary/commentary.component';
import {GenreComponent} from './genre/genre.component';
import {ReaderComponent} from './reader/reader.component';
import {Routes, RouterModule, Resolve, ActivatedRouteSnapshot} from '@angular/router';
import {AuthorFormComponent} from './author-form/author-form.component';
import {BookFormComponent} from './book-form/book-form.component';
import {CommentaryFormComponent} from './commentary-form/commentary-form.component';
import {GenreFormComponent} from './genre-form/genre-form.component';
import {ReaderFormComponent} from './reader-form/reader-form.component';
import {FormsModule} from '@angular/forms';
import {Author} from './author/author';
import {Observable, of} from 'rxjs';
import {AuthorServiceService} from './service/author-service.service';
import {Book} from './book/book';
import {BookServiceService} from './service/book-service.service';
import {Genre} from './genre/genre';
import {GenreServiceService} from './service/genre-service.service';
import {Commentary} from './commentary/commentary';
import {CommentaryServiceService} from './service/commentary-service.service';
import {Reader} from './reader/reader';
import {ReaderServiceService} from './service/reader-service.service';

@Injectable({providedIn: 'root'})
export class AuthorResolve implements Resolve<Author> {
  constructor(public service: AuthorServiceService) {
  }

  resolve(route: ActivatedRouteSnapshot): Observable<Author> | Promise<Author> | Author {
    const id = route.params.id;
    console.log(id);
    if (!!id) {
      return this.service.updateAuthor(id);
    } else {
      return of(new Author());
    }
  }
}

@Injectable({providedIn: 'root'})
export class BookResolve implements Resolve<Book> {
  constructor(public service: BookServiceService) {
  }

  resolve(route: ActivatedRouteSnapshot): Observable<Book> | Promise<Book> | Book {
    const id = route.params.id;
    console.log(id);
    if (!!id) {
      return this.service.updateBook(id);
    } else {
      return of(new Book());
    }
  }
}

@Injectable({providedIn: 'root'})
export class BooksResolve implements Resolve<Book[]> {
  constructor(public service: BookServiceService) {
  }

  resolve(route: ActivatedRouteSnapshot): Observable<Book[]>{
    const id = route.params.id;
    console.log(id);
    if (!!id) {
      return this.service.findAllByGenre(id);
    } else {
      return this.service.findAll();
    }
  }
}

@Injectable({providedIn: 'root'})
export class GenreResolve implements Resolve<Genre> {
  constructor(public service: GenreServiceService) {
  }

  resolve(route: ActivatedRouteSnapshot): Observable<Genre> | Promise<Genre> | Genre {
    const id = route.params.id;
    console.log(id);
    if (!!id) {
      return this.service.updateGenre(id);
    } else {
      return of(new Genre());
    }
  }
}

// @Injectable({providedIn: 'root'})
// export class CommentaryResolve implements Resolve<Commentary> {
//   constructor(public service: CommentaryServiceService) {
//   }
//
//   resolve(route: ActivatedRouteSnapshot): Observable<Commentary> | Promise<Commentary> | Commentary {
//     const id = route.params.id;
//     console.log(id);
//     if (!!id) {
//       return this.service.updateComment(id);
//     } else {
//       return of(new Commentary());
//     }
//   }
// }

@Injectable({providedIn: 'root'})
export class ReaderResolve implements Resolve<Reader> {
  constructor(public service: ReaderServiceService) {
  }

  resolve(route: ActivatedRouteSnapshot): Observable<Reader> | Promise<Reader> | Reader {
    const id = route.params.id;
    console.log(id);
    if (!!id) {
      return this.service.updateReader(id);
    } else {
      return of(new Reader());
    }
  }
}

const appRoutes: Routes = [
  {
    path: 'author', children: [
      {path: '', component: AuthorComponent},
      {path: 'create', component: AuthorFormComponent},
      {path: ':id', component: AuthorFormComponent, resolve: {author: AuthorResolve}}
    ]
  },
  {
    path: 'book', children: [
      {path: '', component: BookComponent, resolve: {books: BooksResolve}},
      {path: 'create', component: BookFormComponent},
      {path: 'new', redirectTo: '/comment/create'},
      {path: ':id', children: [
          {path: '', component: BookFormComponent, resolve: {book: BookResolve}},
          // {path: 'new', component: CommentaryFormComponent}
        ]}
    ]
  },
  {
    path: 'comment', children: [
      {path: '', component: CommentaryComponent},
      {path: 'create', component: CommentaryFormComponent},
    ]
  },
  {
    path: 'genre', children: [
      {path: '', component: GenreComponent},
      {path: 'create', component: GenreFormComponent},
      {
        path: ':id', children: [
          {path: '', component: GenreFormComponent, resolve: {genre: GenreResolve}},
          {
            path: 'book', children: [
              {path: '', component: BookComponent, resolve: {books: BooksResolve}},
              {path: 'create', component: BookFormComponent},
              {path: 'new', redirectTo: '/comment/create'},
              {path: ':id', component: BookFormComponent, resolve: {book: BookResolve}}
            ]
          }
        ]
      }
    ]
  },
  {
    path: 'reader', children: [
      {path: '', component: ReaderComponent},
      {path: 'create', component: ReaderFormComponent},
      {path: ':id', component: ReaderFormComponent, resolve: {reader: ReaderResolve}}
    ]
  }
];

@NgModule({
  declarations: [
    AppComponent,
    AuthorComponent,
    BookComponent,
    CommentaryComponent,
    GenreComponent,
    ReaderComponent,
    AuthorFormComponent,
    BookFormComponent,
    CommentaryFormComponent,
    GenreFormComponent,
    ReaderFormComponent
  ],
  imports: [
    BrowserModule,
    NgbModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
