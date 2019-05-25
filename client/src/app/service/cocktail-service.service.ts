import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Cocktail } from '../model/cocktail';
import { Observable } from "rxjs";
import { Ingridient } from '../model/ingridient';
import { General } from '../model/general';

@Injectable()
export class CocktailServiceService {

  private cocktailUrl: string;
  private general: General;

  constructor(private http: HttpClient) {
    this.cocktailUrl = 'http://localhost:8080/create-cocktail';
    this.general = new General();
  }

  public findAll(): Observable<General[]> {
    return this.http.get<General[]>("http://localhost:8080/read-all-cocktail");
  }

  public findAllIngridients(): Observable<Ingridient[]> {
    return this.http.get<Ingridient[]>("http://localhost:8080/read-all-ingridients");
  }

  public save(cocktail: Cocktail, ingridients: Ingridient[]) {
    
    this.general.cocktailName = cocktail.name;
    for (let i = 0; i < ingridients.length; i++) {
      this.general.ingridientsNames.push(ingridients[i]);
    }

    return this.http.post<Ingridient>("http://localhost:8080/create-cocktail-ingridient", this.general);

  }

}
