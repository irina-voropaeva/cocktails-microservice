import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CocktailsListComponent } from './cocktails-list/cocktails-list.component';
import { CocktailFormComponent } from './cocktail-form/cocktail-form.component';
import {IngridientFormComponent } from './ingridient-form/ingridientform.component'

const routes: Routes = [
  { path: 'cocktails', component: CocktailsListComponent },
  { path: 'addcocktail', component: CocktailFormComponent },
  { path: 'addingridient', component: IngridientFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
