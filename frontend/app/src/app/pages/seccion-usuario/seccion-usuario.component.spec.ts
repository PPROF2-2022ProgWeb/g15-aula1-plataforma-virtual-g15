import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeccionUsuarioComponent } from './seccion-usuario.component';

describe('SeccionUsuarioComponent', () => {
  let component: SeccionUsuarioComponent;
  let fixture: ComponentFixture<SeccionUsuarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SeccionUsuarioComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SeccionUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
