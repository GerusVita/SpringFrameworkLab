import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReaderFormComponent } from './reader-form.component';

describe('ReaderFormComponent', () => {
  let component: ReaderFormComponent;
  let fixture: ComponentFixture<ReaderFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReaderFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReaderFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
