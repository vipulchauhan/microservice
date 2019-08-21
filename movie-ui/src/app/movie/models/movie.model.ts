export class Movie {

  public name: string;
  public desc: string;
  public ratting: number;

  constructor(movieName: string, description: string, rating: number) {
    this.name = movieName;
    this.desc = description;
    this.ratting = rating;
  }

}
