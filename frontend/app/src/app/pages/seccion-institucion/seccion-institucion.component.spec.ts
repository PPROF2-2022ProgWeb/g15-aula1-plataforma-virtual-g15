import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeccionInstitucionComponent } from './seccion-institucion.component';

describe('SeccionInstitucionComponent', () => {
  let component: SeccionInstitucionComponent;
  let fixture: ComponentFixture<SeccionInstitucionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SeccionInstitucionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SeccionInstitucionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
