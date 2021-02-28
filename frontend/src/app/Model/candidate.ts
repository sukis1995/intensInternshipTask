import { logging } from 'protractor';

export interface Candidate {
  id: number;
  fullName: String;
  dateOfBirth: Date;
  contactNumber: String;
  email: String;
}
