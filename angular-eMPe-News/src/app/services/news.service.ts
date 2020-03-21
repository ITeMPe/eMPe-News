import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { News } from '../common/news';

@Injectable({
  providedIn: 'root'
})
export class NewsService {

private baseUrl = "http://localhost:8080/headlines/pl/technology";

constructor(private httpClient: HttpClient) { }

  getNews(): Observable<News[]>{
    return this.httpClient.get<GetResponseNews>(this.baseUrl).pipe(
      map(response => response.alldata)
    );
  }
}

interface GetResponseNews{
  alldata: News[];
}
