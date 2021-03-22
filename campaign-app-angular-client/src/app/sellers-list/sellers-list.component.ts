import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Seller } from '../Models';
import { SellerService } from '../services/seller.service';

@Component({
  selector: 'app-sellers-list',
  templateUrl: './sellers-list.component.html',
  styleUrls: ['./sellers-list.component.css']
})
export class SellersListComponent implements OnInit {

  public sellers: Observable<Seller[]>;
  public listSellers: Seller[];

  constructor(private _sellerService: SellerService) {}

  ngOnInit() {
  this.reloadData()
  }

  reloadData() {
    this._sellerService.getSellerList()
    .subscribe
    (
      data =>
      {
        this.listSellers = data;
      }
    )
  }

  
}
