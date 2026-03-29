import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FeedbackRequest } from '../models/feedback-request';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class Feedback {
  
    private apiUrl = "http://localhost:8080/api/feedback";

  constructor(private http: HttpClient) {}

  submitFeedback(request: FeedbackRequest): Observable<any> {
    return this.http.post(this.apiUrl, request);
  }
}
