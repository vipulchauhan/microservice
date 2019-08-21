import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Movie} from '../models/movie.model';
import {Subject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MovieCatalogService {

  constructor(private http: HttpClient) {
  }

  private movieCatalogUrl = 'http://localhost:8081/catalog/foo';
  private movies: Movie[] = [];
  public movieChanged = new Subject<Movie[]>();

  getMovieCatalog() {
    this.http.get(this.movieCatalogUrl).subscribe((data: Movie[]) => {
      this.movies = data;
      this.movieChanged.next(this.movies);
    });
  }

}
