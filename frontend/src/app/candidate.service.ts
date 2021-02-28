import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Candidate } from './Model/candidate';
import { environment } from 'src/environments/environment';
import { Skill } from './Model/Skill';
@Injectable({
  providedIn: 'root',
})
export class CandidateService {
  private apiServerUrl = environment.apiBaseUrl;
  constructor(private http: HttpClient) {}

  public getCandidates(): Observable<Candidate[]> {
    return this.http.get<any>(`${this.apiServerUrl}/api/candidates`);
  }
  public addCandidate(candidate: Candidate): Observable<Candidate> {
    return this.http.post<Candidate>(
      `${this.apiServerUrl}/api/candidates`,
      candidate
    );
  }

  public removeSkillFromCandidate(
    idCandidate: number,
    idSkill: number
  ): Observable<Candidate> {
    return this.http.delete<any>(
      `${this.apiServerUrl}/api/candidates/removeSkill/${idCandidate}/${idSkill}`
    );
  }

  public removeCandidate(id: number): Observable<Candidate> {
    return this.http.delete<any>(`${this.apiServerUrl}/api/candidates/${id}`);
  }

  public searchCandidatesByName(name: {}): Observable<Candidate[]> {
    return this.http.get<any>(
      `${this.apiServerUrl}/api/candidates/findByName`,
      { params: name }
    );
  }

  public searchCandidateBySkills(parameters: []): Observable<Candidate[]> {
    let params = new HttpParams();
    params = params.append('numOfParams', parameters.length.toString());
    parameters.forEach((skill: Skill, index: number) => {
      params = params.append(
        'Skill' + (index + 1).toString(),
        skill.id.toString()
      );
      console.log(params);
    });

    return this.http.get<any>(`${this.apiServerUrl}/api/candidates`, {
      params: params,
    });
  }

  public addSkillToCandidate(
    idCandidate: number,
    skill: Skill
  ): Observable<any> {
    return this.http.put<Candidate>(
      `${this.apiServerUrl}/api/candidates/addSkill/${idCandidate}`,
      skill
    );
  }
}
