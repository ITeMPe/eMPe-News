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


  getNews(): Observable<GetResponseNews>{
    return this.httpClient.get<GetResponseNews>(this.baseUrl);
  }
  
}


interface GetResponseNews{
  articles: News[];
  category: number;
  country: string;
}
