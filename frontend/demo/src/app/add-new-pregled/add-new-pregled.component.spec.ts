import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddNewPregledComponent } from './add-new-pregled.component';

describe('AddNewPregledComponent', () => {
  let component: AddNewPregledComponent;
  let fixture: ComponentFixture<AddNewPregledComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddNewPregledComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddNewPregledComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
