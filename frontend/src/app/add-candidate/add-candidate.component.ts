import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MatDatepickerInput } from '@angular/material/datepicker';
import { MatDialog } from '@angular/material/dialog';
import { CandidateService } from '../candidate.service';
import { CandidatesComponent } from '../candidates/candidates.component';

@Component({
  selector: 'AddCandidateComponent',
  templateUrl: './add-candidate.component.html',
  styleUrls: ['./add-candidate.component.css'],
})
export class AddCandidateComponent implements OnInit {
  formGroup: FormGroup;
  constructor(
    private candidateService: CandidateService,
    private dialog: MatDialog
  ) {}

  ngOnInit(): void {
    this.formGroup = new FormGroup({
      fullName: new FormControl(''),
      email: new FormControl(''),
      contactNumber: new FormControl(''),
      dateOfBirth: new FormControl(),
    });
  }

  addCandidate(event) {
    event.preventDefault();
    console.log(this.formGroup.value);
    this.candidateService.addCandidate(this.formGroup.value).subscribe(
      (response) => {
        this.dialog.closeAll();
      },
      (erorr: HttpErrorResponse) => {
        alert(erorr.message);
      }
    );
  }
}
