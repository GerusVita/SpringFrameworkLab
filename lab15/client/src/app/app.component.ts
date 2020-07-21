import {Component} from '@angular/core';
import {HttpClient, HttpClientModule} from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  // template: ``,
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'client';

  // constructor(client: HttpClient) {
  //   client.get('http://localhost:8080/author').subscribe(value => { console.log(value);
  //   });
  // }
}
