import { Component, Input, OnInit } from '@angular/core';
import { CandidateService } from '../candidate.service';

import { CandidatesComponent } from '../candidates/candidates.component';
import { Skill } from '../Model/Skill';

@Component({
  selector: 'SkillComponent',
  templateUrl: './skill.component.html',
  styleUrls: ['./skill.component.css'],
})
export class SkillComponent implements OnInit {
  @Input() skill: Skill;
  @Input() idCandidate: number;
  constructor(
    private candidateService: CandidateService,
    private candidates: CandidatesComponent
  ) {}

  ngOnInit(): void {}

  public deleteSkillFromCandidate() {
    return this.candidateService
      .removeSkillFromCandidate(this.idCandidate, this.skill.id)
      .subscribe((response) => {
        this.candidates.getCandidates();
      });
  }
}
