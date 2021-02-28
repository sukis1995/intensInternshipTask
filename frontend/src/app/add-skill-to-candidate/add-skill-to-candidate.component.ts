import { HttpErrorResponse } from '@angular/common/http';
import { Component, Inject, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { CandidateService } from '../candidate.service';
import { Skill } from '../Model/Skill';
import { SkillService } from '../skill.service';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'AddSkillToCandidateComponent',
  templateUrl: './add-skill-to-candidate.component.html',
  styleUrls: ['./add-skill-to-candidate.component.css'],
})
export class AddSkillToCandidateComponent implements OnInit {
  skills: Skill[];
  uniqueSkills: Skill[];
  formGroup: FormGroup;
  constructor(
    @Inject(MAT_DIALOG_DATA) public data: { list: []; idCandidate: number },

    private skillService: SkillService,
    private candidateService: CandidateService,
    private matDialog: MatDialog
  ) {}

  ngOnInit(): void {
    this.getAllSkills();
    this.formGroup = new FormGroup({
      skill: new FormControl(),
    });
  }

  getAllSkills() {
    this.skillService.getSkills().subscribe(
      (response) => {
        this.skills = response;
        if (this.data.list.length === 0) {
          this.uniqueSkills = this.skills;
        } else {
          this.uniqueSkills = this.skills.filter(
            (s) => !this.data.list.find((s2: Skill) => s.id === s2.id)
          );
        }
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  addSkill() {
    this.candidateService
      .addSkillToCandidate(this.data.idCandidate, this.formGroup.value.skill)
      .subscribe(
        (response) => {
          this.matDialog.closeAll();
        },
        (error) => {
          alert('There was a problem with adding new skill to candidate');
        }
      );
  }
}
