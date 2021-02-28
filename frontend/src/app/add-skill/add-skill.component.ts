import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { SkillService } from '../skill.service';

@Component({
  selector: 'AddSkillComponent',
  templateUrl: './add-skill.component.html',
  styleUrls: ['./add-skill.component.css'],
})
export class AddSkillComponent implements OnInit {
  formGroup: FormGroup;

  constructor(private skillService: SkillService, private dialog: MatDialog) {}

  ngOnInit(): void {
    this.formGroup = new FormGroup({
      name: new FormControl('', [Validators.required]),
    });
  }

  addSkill() {
    this.skillService.addSkill(this.formGroup.value).subscribe(
      (response) => {
        this.dialog.closeAll();
      },
      (error) => {
        alert('There was a problem with adding new skill');
      }
    );
  }
}
