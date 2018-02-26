import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SalidamaderarolloComponent } from './salidamaderarollo.component';

describe('SalidamaderarolloComponent', () => {
  let component: SalidamaderarolloComponent;
  let fixture: ComponentFixture<SalidamaderarolloComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SalidamaderarolloComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SalidamaderarolloComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
