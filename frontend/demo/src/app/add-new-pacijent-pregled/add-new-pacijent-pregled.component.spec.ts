import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddNewPacijentPregledComponent } from './add-new-pacijent-pregled.component';

describe('AddNewPacijentPregledComponent', () => {
  let component: AddNewPacijentPregledComponent;
  let fixture: ComponentFixture<AddNewPacijentPregledComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddNewPacijentPregledComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddNewPacijentPregledComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
