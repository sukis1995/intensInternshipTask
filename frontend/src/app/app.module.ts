import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CandidateComponent } from './candidate/candidate.component';
import { CandidatesComponent } from './candidates/candidates.component';
import { AddCandidateComponent } from './add-candidate/add-candidate.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatFormFieldModule,  } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'
import { MatListModule } from '@angular/material/list'
import {MatSelectModule} from '@angular/material/select';
import { SkillComponent } from './skill/skill.component';
import { SearchBySkillComponent } from './search-by-skill/search-by-skill.component'
import { MatTableModule } from '@angular/material/table';
import { MatCardModule } from '@angular/material/card'
import {MatButtonModule} from '@angular/material/button';
import { AddSkillToCandidateComponent } from './add-skill-to-candidate/add-skill-to-candidate.component';
import { AddSkillComponent } from './add-skill/add-skill.component'
import {DatePipe} from '@angular/common';

@NgModule({
  declarations: [
    
    
    AppComponent,


          CandidateComponent,


          CandidatesComponent,


    AddCandidateComponent,


    SkillComponent,


    SearchBySkillComponent,


    AddSkillToCandidateComponent,


    AddSkillComponent,
   
    
  
  
  ],
  imports: [
    
    
    BrowserModule,
   
   
    AppRoutingModule,
   
   
    HttpClientModule,
   
   
    BrowserAnimationsModule,
    MatDatepickerModule,
    MatFormFieldModule, 
    MatNativeDateModule,
    MatInputModule,
    MatIconModule,
    FormsModule,
    ReactiveFormsModule,
    MatListModule,
    MatSelectModule,
    MatTableModule,
    MatCardModule,
    MatButtonModule
  
  ],
  providers: [DatePipe,CandidatesComponent],
  bootstrap: [AppComponent],
})
export class AppModule {}
