import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EntradamaderarolloComponent } from './entradamaderarollo.component';

describe('EntradamaderarolloComponent', () => {
  let component: EntradamaderarolloComponent;
  let fixture: ComponentFixture<EntradamaderarolloComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EntradamaderarolloComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EntradamaderarolloComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
