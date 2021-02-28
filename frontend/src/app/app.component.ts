import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Candidate } from './Model/candidate';
import { CandidateService } from './candidate.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  title = 'frontend';
  public candidates: Candidate[];
  
  constructor(private candidateService:  CandidateService)  {}

  ngOnInit() {
    this.getCandidates();
  }

  public getCandidates(): void  {
    this.candidateService.getCandidates().subscribe(
      (response: Candidate[]) => {
        this.candidates = response;
      },
  
         (error: HttpErrorResponse) => {
        alert(error.message);;
      }
    );;
  }
}
