import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { TokenResponse } from "../model/tokenResponse";

@Injectable({
    providedIn:'root'
})

//to handle token validation
export class AuthService{

    //authentication microservice
    authserviceurl = "http://localhost:8080/authapp"
    //authserviceurl = "http://pod4-cc-lb-722089690.us-east-2.elb.amazonaws.com/authapp"

    constructor(private http:HttpClient){}

    //to check validity of the token
    isAuthenticated(token:string){
        let options={
            headers:{"Authorization":"Bearer "+token}
        }
        return this.http.get<TokenResponse>(this.authserviceurl + "/validate",options);
    }

    //to logout the user
    logout(){
        localStorage.clear()
    }
}