import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Skill } from './Model/Skill';

@Injectable({
  providedIn: 'root',
})
export class SkillService {
  private apiUrl = environment.apiBaseUrl;
  constructor(private http: HttpClient) {}

  public getSkillByCandidate(id): Observable<Skill[]> {
    return this.http.get<any>(
      `${this.apiUrl}/api/skills/findByCandidate/${id}`
    );
  }

  public getSkills(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/api/skills`);
  }

  public addSkill(skill: Skill): Observable<Skill> {
    return this.http.post<any>(`${this.apiUrl}/api/skills`, skill);
  }
}
