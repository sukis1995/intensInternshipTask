import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Candidate } from '../Model/candidate';
import { CandidateService } from '../candidate.service';
import { FormControl, FormGroup } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { AddCandidateComponent } from '../add-candidate/add-candidate.component';
import { AddSkillComponent } from '../add-skill/add-skill.component';
import { SearchBySkillComponent } from '../search-by-skill/search-by-skill.component';
import { SkillService } from '../skill.service';
import { Skill } from '../Model/Skill';

@Component({
  selector: 'CandidatesComponent',
  templateUrl: './candidates.component.html',
  styleUrls: ['./candidates.component.css'],
})
export class CandidatesComponent implements OnInit {
  public candidates: Candidate[];
  public skills: Skill[];
  public formGroupName: FormGroup;
  public formGroupSkill: FormGroup;
  public showFormName: boolean;
  public showFromSkill: boolean;
  constructor(
    private candidateService: CandidateService,
    private dialog: MatDialog,
    private skillService: SkillService
  ) {}

  ngOnInit() {
    this.getCandidates();
    this.getSkills();
    this.formGroupName = new FormGroup({
      fullName: new FormControl(''),
    });
    this.formGroupSkill = new FormGroup({
      skillSelected: new FormControl([]),
    });
  }

  public getCandidates(): void {
    this.candidateService.getCandidates().subscribe(
      (response: Candidate[]) => {
        this.candidates = response;
      },

      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchCandidatesByName(): void {
    console.log(this.formGroupName.value);
    this.candidateService
      .searchCandidatesByName(this.formGroupName.value)
      .subscribe(
        (response) => {
          this.candidates = response;
        },

        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );
  }

  public showFormNameFunction() {
    this.showFormName = !this.showFormName;
  }

  public showAddCandidateForm() {
    const dialog = this.dialog.open(AddCandidateComponent);
    dialog.afterClosed().subscribe(() => {
      this.getCandidates();
    });
  }

  public showAddSkillForm() {
    const dialog = this.dialog.open(AddSkillComponent);
    dialog.afterClosed().subscribe(() => {});
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
      .searchCandidateBySkills(this.formGroupSkill.value.skillSelected)
      .subscribe((response) => {
        this.candidates = response;
      });
  }

  public showFormFunctionSkill() {
    this.showFromSkill = !this.showFromSkill;
  }
}
