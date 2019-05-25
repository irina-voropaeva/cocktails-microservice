import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CocktailServiceService } from '../service/cocktail-service.service';
import { Cocktail } from '../model/cocktail';
import { Ingridient } from '../model/ingridient';

@Component({
  selector: 'cocktail-form',
  templateUrl: './cocktail-form.component.html',
  styleUrls: ['./cocktail-form.component.css']
})
export class CocktailFormComponent {

  cocktail: Cocktail;
  ingridients: Ingridient[];
  checkboxes: Ingridient[];

  constructor(private route: ActivatedRoute, private router: Router, private cocktailService: CocktailServiceService) {
    this.cocktail = new Cocktail();
    cocktailService.findAllIngridients().subscribe(data => {
      this.ingridients = data;
    });
  }

  onSubmit() {
    console.log(this.checkboxes);
    this.cocktailService.save(this.cocktail, this.checkboxes).subscribe(result => this.gotoCocktailsList());
  }

  gotoCocktailsList() {
    this.router.navigate(['/cocktails']);
  }

  onClick(item: Ingridient) {
    if (this.checkboxes != undefined) {
      for (let i = 0; i < this.checkboxes.length; i++) {
        if (item == this.checkboxes[i]) {
          this.checkboxes.splice(i, 1);
          break;
        } else {
          this.checkboxes.push(item);
          break;
        }
      }
    } else {
      
      this.checkboxes.push(item);
    }
  }
}
