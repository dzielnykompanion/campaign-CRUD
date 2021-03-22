import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CreateCampaignComponent } from './create-campaign/create-campaign.component';
import { CampaignDetailsComponent } from './campaign-details/campaign-details.component';
import { CampaignListComponent } from './campaign-list/campaign-list.component';
import { SellersListComponent } from './sellers-list/sellers-list.component';

import { HttpClientModule } from '@angular/common/http';
import { CampaignsListComponent } from './campaigns-list/campaigns-list.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateCampaignComponent,
    CampaignDetailsComponent,
    CampaignListComponent,
    SellersListComponent,
    CampaignsListComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
