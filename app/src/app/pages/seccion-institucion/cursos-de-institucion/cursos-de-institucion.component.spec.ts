import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CursosDeInstitucionComponent } from './cursos-de-institucion.component';

describe('CursosDeInstitucionComponent', () => {
  let component: CursosDeInstitucionComponent;
  let fixture: ComponentFixture<CursosDeInstitucionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CursosDeInstitucionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CursosDeInstitucionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
