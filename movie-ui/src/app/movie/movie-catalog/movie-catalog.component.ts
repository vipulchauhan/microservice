import {Component, OnDestroy, OnInit} from '@angular/core';
import {Movie} from '../models/movie.model';
import {MovieCatalogService} from '../services/movie-catalog.service';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-movie-catalog',
  templateUrl: './movie-catalog.component.html',
  styleUrls: ['./movie-catalog.component.css']
})
export class MovieCatalogComponent implements OnInit, OnDestroy {
  moviesList: Movie[];
  private moviesSubscription: Subscription;

  constructor(private movieCatalogService: MovieCatalogService) {
    this.movieCatalogService.getMovieCatalog();
    this.moviesSubscription = this.movieCatalogService.movieChanged.subscribe(
      (ms: Movie[]) => {
        this.moviesList = ms;
        console.log('Array');
        console.log(JSON.stringify(this.moviesList));
      }
    );
  }

  ngOnInit() {


  }

  ngOnDestroy(): void {
    this.moviesSubscription.unsubscribe();
  }


}
