import { Component, OnInit } from '@angular/core';
import { ConfigService } from '../config/config.service';
import { Offer } from '../model/Offer';

@Component({
  selector: 'app-my-offers',
  templateUrl: './my-offers.component.html',
  styleUrls: ['./my-offers.component.css']
})

export class MyOffersComponent implements OnInit {
  //offers array to save all the offers retrieved
  offers:Offer[] = []

  pageError:string=""

  //config service - http client
  constructor(private configService:ConfigService) { }

  ngOnInit(): void {
    //get token and empId
    let token = localStorage.getItem("token")
    let id = Number(localStorage.getItem('userId'))

    //retrieve the data
    if(token!=null){
      this.configService.getMyOffers(token,id).subscribe((data:Offer[])=>{
        this.offers = data;
      },error=>{
        console.log(error)

        //if no offers are present
        if(error.status==404){
          this.offers = []
          this.pageError = "Sorry! No offers found , to add a new offer click on Post an offer"
        }

        //any other errors
        else{
          this.pageError = "Sorry! some error occured please try again later"
        }
      })
    }
  }

  //difference calculation to update status of offer
  calculateDifference(closeDate:any) {
    if(closeDate == null){
      return 'open';
    }
    let todayDate = new Date();
    let closedDate = new Date(closeDate);
    var diff = todayDate.getTime() - closedDate.getTime();
    //var diffDays = Math.ceil(diff / (1000 * 3600 * 24)); 
    return diff >= 0 ? 'closed' : 'open';
  }
}
