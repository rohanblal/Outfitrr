import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SavedOutfit {

  private apiUrl = "http://localhost:8080/api/outfits";

  constructor(private http: HttpClient) {}

  saveOutfit(request: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/save`, request);
  }
  getSavedOutfits(): Observable<any>{
  return this.http.get(this.apiUrl);
}
deleteOutfit(id: number): Observable<any>{
  return this.http.delete(`${this.apiUrl}/${id}`, {
    responseType: 'text'
  });
}
}