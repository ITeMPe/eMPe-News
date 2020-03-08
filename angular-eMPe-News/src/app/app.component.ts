import { Component } from '@angular/core';
import { News } from './common/news';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-eMPe-News';
  clickButton() {  
    let num = 10;  
    num++;  
    alert(`Value of 'num' is : ${num}`);  
  }  

}
