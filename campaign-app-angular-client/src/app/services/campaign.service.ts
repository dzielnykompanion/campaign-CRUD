import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Campaign } from '../Models';


@Injectable({
  providedIn: 'root'
})
export class CampaignService {
  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  getCampaign(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createCampaign(campaign: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/addCampaign`, campaign);
  }

  updateCampaign(id: number, value: any): Observable<Object> {
    return this.http.post(`${this.baseUrl}/addCampaign`, value);
  }

  deleteCampaign(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getCampaignList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/getAll`);
  }
}
