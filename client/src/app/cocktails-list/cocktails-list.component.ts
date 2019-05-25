import { Component, OnInit } from '@angular/core';
import { CocktailServiceService } from '../service/cocktail-service.service';
import { General } from '../model/general';

@Component({
  selector: 'cocktails-list',
  templateUrl: './cocktails-list.component.html',
  styleUrls: ['./cocktails-list.component.css']
})
export class CocktailsListComponent implements OnInit {

  cocktails: General[];

  constructor(private cocktailsService: CocktailServiceService) {
  }

  ngOnInit() {
    this.cocktailsService.findAll().subscribe(data => {
      this.cocktails = data;
    });
  }
}
