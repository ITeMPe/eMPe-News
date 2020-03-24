import { Component, OnInit } from '@angular/core';
import { News } from '../../common/news';
import { NewsService } from '../../services/news.service';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {

news: News[];

constructor(private _newsService: NewsService) { }

  ngOnInit() {
    this.listNews();
  }

listNews() {
  this._newsService.getNews().subscribe(
    data => this.news = data.articles.map(article => {
      return {
        ...article,
        category: data.category,
        country: data.country
      };
    })
  );
}

}
