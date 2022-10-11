import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CommerceHeaderComponent } from './commerce-header.component';

describe('CommerceHeaderComponent', () => {
  let component: CommerceHeaderComponent;
  let fixture: ComponentFixture<CommerceHeaderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CommerceHeaderComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CommerceHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
