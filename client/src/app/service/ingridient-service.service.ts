import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Ingridient } from '../model/ingridient';
import { Observable } from "rxjs";

@Injectable()
export class IngridientServiceService {

  private ingridientUrl: string;

  constructor(private http: HttpClient) {
    this.ingridientUrl = 'http://localhost:8080/create-ingridient';
  }

  public findAll(): Observable<Ingridient[]> {
    return this.http.get<Ingridient[]>("http://localhost:8080/read-all-ingridients");
  }

  public save(ingridient: Ingridient) {
    return this.http.post<Ingridient>(this.ingridientUrl, ingridient);
  }
}
