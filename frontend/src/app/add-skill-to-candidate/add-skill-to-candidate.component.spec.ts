import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddSkillToCandidateComponent } from './add-skill-to-candidate.component';

describe('AddSkillToCandidateComponent', () => {
  let component: AddSkillToCandidateComponent;
  let fixture: ComponentFixture<AddSkillToCandidateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddSkillToCandidateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddSkillToCandidateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
