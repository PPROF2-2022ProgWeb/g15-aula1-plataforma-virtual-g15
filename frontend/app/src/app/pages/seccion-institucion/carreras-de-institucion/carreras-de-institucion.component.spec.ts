import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarrerasDeInstitucionComponent } from './carreras-de-institucion.component';

describe('CarrerasDeInstitucionComponent', () => {
  let component: CarrerasDeInstitucionComponent;
  let fixture: ComponentFixture<CarrerasDeInstitucionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CarrerasDeInstitucionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CarrerasDeInstitucionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
