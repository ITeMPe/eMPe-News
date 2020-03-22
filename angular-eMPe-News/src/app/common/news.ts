import { Articles } from './articles';

export class News {
  country: string;
  category: number;
  status: string;         // additional value for me
  totalResults: number;   // additional value for me
  articles: Articles[]
  }
