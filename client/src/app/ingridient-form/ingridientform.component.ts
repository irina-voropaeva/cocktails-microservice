import { Component, OnInit } from '@angular/core';
import { Ingridient } from '../model/ingridient';
import { IngridientServiceService } from '../service/ingridient-service.service';
import { Router, ActivatedRoute } from '@angular/router';
import { CocktailServiceService } from '../service/cocktail-service.service';

@Component({
  selector: 'ingridientform',
  templateUrl: './ingridientform.component.html',
  styleUrls: ['./ingridientform.component.css'],
  providers: [IngridientServiceService]
})
export class IngridientFormComponent {

  ingridient: Ingridient;

  constructor(private route: ActivatedRoute, private router: Router, private ingridientService: IngridientServiceService) { 
    this.ingridient = new Ingridient();

  }

  onSubmit() {
      console.log(this.ingridient);
      this.ingridientService.save(this.ingridient).subscribe(result => this.gotoCocktailsList());
    }
    gotoCocktailsList() {
    this.router.navigate(['/cocktails']);
  }

}
