import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IngridientFormComponent } from './ingridientform.component';

describe('IngridientFormComponent', () => {
  let component: IngridientFormComponent;
  let fixture: ComponentFixture<IngridientFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IngridientFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IngridientFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
