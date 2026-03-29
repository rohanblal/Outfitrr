import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RecommendRequest } from '../models/recommend-request';
import { Observable } from 'rxjs';
import { RecommendationResult } from '../models/recommendation-result';

@Injectable({
  providedIn: 'root',
})
export class Recommendation {
  
  private apiUrl = "http://localhost:8080/api/recommend";

  constructor(private http : HttpClient){}

  getRecommendations(request: RecommendRequest): Observable<RecommendationResult[]>{
    return this.http.post<RecommendationResult[]>(this.apiUrl, request);
  }
}
