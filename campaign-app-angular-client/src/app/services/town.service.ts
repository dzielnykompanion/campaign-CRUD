import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Town } from '../Models';

@Injectable({
  providedIn: 'root'
})
export class TownService {
  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  getTown(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/town/${id}`);
  }

}