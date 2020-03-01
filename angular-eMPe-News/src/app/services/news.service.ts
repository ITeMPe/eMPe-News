import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { News } from '../common/news';

@Injectable({
  providedIn: 'root'
})
export class NewsService {

private baseUrl___ = "http://localhost:8080/headlines/";
private baseUrl = "http://newsapi.org/v2/top-headlines?country=pl&category=technology&apiKey=d5cb1c65bb3442048ecba183138ceaef";

constructor(private httpClient: HttpClient) { }

  getNews(): Observable<News[]>{
    return this.httpClient.get<GetResponseNews>(this.baseUrl).pipe(
      map(response => response._embedded.news)
    );
  }
}

interface GetResponseNews{
  _embedded: {
    news: News[];
  }
}
