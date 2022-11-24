/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { PagoService } from './pago.service';

describe('Service: Pago', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PagoService]
    });
  });

  it('should ...', inject([PagoService], (service: PagoService) => {
    expect(service).toBeTruthy();
  }));
});
