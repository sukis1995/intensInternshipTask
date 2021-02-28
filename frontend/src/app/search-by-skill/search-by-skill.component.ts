import { HttpErrorResponse } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { CandidateService } from '../candidate.service';
import { CandidateComponent } from '../candidate/candidate.component';
import { CandidatesComponent } from '../candidates/candidates.component';
import { Candidate } from '../Model/candidate';
import { Skill } from '../Model/Skill';
import { SkillService } from '../skill.service';

@Component({
  selector: 'SearchBySkillComponent',
  templateUrl: './search-by-skill.component.html',
  styleUrls: ['./search-by-skill.component.css'],
})
export class SearchBySkillComponent implements OnInit {
  @Input() candidates: Candidate[];
  public skills: Skill[];
  public formGroup: FormGroup;
  constructor(
    private candidatesComponent: CandidatesComponent,
    private skillService: SkillService,
    private candidateService: CandidateService
  ) {}

  ngOnInit(): void {
    this.getSkills();
    this.formGroup = new FormGroup({
      skillSelected: new FormControl(),
    });
  }

  public getSkills() {
    this.skillService.getSkills().subscribe(
      (response) => {
        this.skills = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchCandidateBySkills() {
    this.candidateService
      .searchCandidateBySkills(this.formGroup.value.skillSelected)
      .subscribe((response) => {
        this.candidates = response;
      });
  }
}
