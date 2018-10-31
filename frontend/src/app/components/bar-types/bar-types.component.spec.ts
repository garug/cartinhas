import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BarTypesComponent } from './bar-types.component';

describe('BarTypesComponent', () => {
  let component: BarTypesComponent;
  let fixture: ComponentFixture<BarTypesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BarTypesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BarTypesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
