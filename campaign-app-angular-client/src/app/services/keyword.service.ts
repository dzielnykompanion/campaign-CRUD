import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Keyword } from '../Models';

@Injectable({
  providedIn: 'root'
})
export class KeywordService {
  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  getKeyword(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/keyword/${id}`);
  }

}
