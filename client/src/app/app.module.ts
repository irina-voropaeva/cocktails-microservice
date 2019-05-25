import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CocktailsListComponent } from './cocktails-list/cocktails-list.component';
import { CocktailFormComponent } from './cocktail-form/cocktail-form.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {CocktailServiceService} from "./service/cocktail-service.service";
import { IngridientFormComponent } from './ingridient-form/ingridientform.component';

@NgModule({
  declarations: [
    AppComponent,
    CocktailsListComponent,
    CocktailFormComponent,
    IngridientFormComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [CocktailServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
