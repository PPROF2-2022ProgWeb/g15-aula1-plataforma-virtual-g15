import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistroInstitucionesComponent } from './registro-instituciones.component';

describe('RegistroInstitucionesComponent', () => {
  let component: RegistroInstitucionesComponent;
  let fixture: ComponentFixture<RegistroInstitucionesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistroInstitucionesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegistroInstitucionesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
