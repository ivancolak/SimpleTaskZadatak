import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaPregledaPacijentaComponent } from './lista-pregleda-pacijenta.component';

describe('ListaPregledaPacijentaComponent', () => {
  let component: ListaPregledaPacijentaComponent;
  let fixture: ComponentFixture<ListaPregledaPacijentaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListaPregledaPacijentaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaPregledaPacijentaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
