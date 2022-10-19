import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Userlogin } from './model/userlogin';


@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private baseURL = environment.baseUrl + "/auth";
  private loginURL = this.baseURL + "/login"

  constructor(private httpClient: HttpClient) { }

  userLogin(user: Userlogin): Observable<any>{
    return this.httpClient.post(`${this.loginURL}`, user);

  }

  checkLogin(): boolean{
    let isLogged = true;
    let session = localStorage.getItem('session');
    if(session==null){
      isLogged=false;
    }
    return isLogged;
  }


}
