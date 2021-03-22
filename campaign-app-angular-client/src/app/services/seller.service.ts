import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Seller } from '../Models';

@Injectable({
  providedIn: 'root'
})
export class SellerService {
  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  getSeller(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/seller/${id}`);
  }

  updateSeller(id: number, value: any): Observable<Object> {
    return this.http.post(`${this.baseUrl}/addSeller`, value);
  }

  getSellerList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/seller/getAll`);
  }

}