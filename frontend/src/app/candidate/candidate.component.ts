import { HttpErrorResponse } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { CandidateService } from '../candidate.service';
import { CandidatesComponent } from '../candidates/candidates.component';
import { Candidate } from '../Model/candidate';
import { Skill } from '../Model/Skill';
import { SkillService } from '../skill.service';
import { MatDialog } from '@angular/material/dialog';
import { AddSkillToCandidateComponent } from '../add-skill-to-candidate/add-skill-to-candidate.component';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'CandidateComponent',
  templateUrl: './candidate.component.html',
  styleUrls: ['./candidate.component.css'],
})
export class CandidateComponent implements OnInit {
  @Input() candidate: Candidate;
  skills: Skill[] = [];
  constructor(
    private skillService: SkillService,
    private candidateService: CandidateService,
    private candidates: CandidatesComponent,
    public dialog: MatDialog,
    private datePipe: DatePipe
  ) {}

  ngOnInit(): void {
    this.getSkillByCandidate();
  }

  public getSkillByCandidate() {
    this.skillService.getSkillByCandidate(this.candidate.id).subscribe(
      (response) => {
        this.skills = response;
      },
      (error: HttpErrorResponse) => {
        //alert(error.message);
      }
    );
  }

  public deleteCandidate() {
    this.candidateService.removeCandidate(this.candidate.id).subscribe(
      (response) => {
        alert('Successfull removal of candidate');
        this.candidates.getCandidates();
      },
      (response) => {
        alert('There was a problem regarding removal of candidate');
      }
    );
  }

  public popUp() {
    const dialog = this.dialog.open(AddSkillToCandidateComponent, {
      data: {
        list: this.skills,
        idCandidate: this.candidate.id,
      },
    });
    dialog.afterClosed().subscribe(() => {
      this.candidates.getCandidates();
    });
  }
}
