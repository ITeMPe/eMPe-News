import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { News } from '../common/news';

@Injectable({
  providedIn: 'root'
})
export class NewsService {

private baseUrl = "http://localhost:8080/news/pl/technology";

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
