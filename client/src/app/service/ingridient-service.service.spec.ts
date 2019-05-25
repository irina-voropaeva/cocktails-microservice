import { TestBed } from '@angular/core/testing';

import { IngridientServiceService } from './ingridient-service.service';

describe('IngridientServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: IngridientServiceService = TestBed.get(IngridientServiceService);
    expect(service).toBeTruthy();
  });
});
