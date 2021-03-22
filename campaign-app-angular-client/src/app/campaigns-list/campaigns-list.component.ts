import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Campaign } from '../Models';
import { CampaignService } from '../services/campaign.service';

@Component({
  selector: 'app-campaigns-list',
  templateUrl: './campaigns-list.component.html',
  styleUrls: ['./campaigns-list.component.css']
})
export class CampaignsListComponent implements OnInit {

  public campaign: Observable<Campaign[]>;
  public listCampaigns: Campaign[];

  constructor(private _campaignService: CampaignService) {}

  ngOnInit() {
  this.reloadData()
  }

  reloadData() {
    this._campaignService.getCampaignList()
    .subscribe
    (
      data =>
      {
        this.listCampaigns = data;
      }
    )
  }
}


