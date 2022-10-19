import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { User } from '../../user/model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseURL = environment.baseUrl + "/userhandler";
  private listURL = this.baseURL + "/users"
  private createURL = this.baseURL + "/newuser"


  constructor(private httpClient: HttpClient) { }

  getUsersList(): Observable<User[]>{
    return this.httpClient.get<User[]>(`${this.listURL}`);
  }
  createUser(user: User): Observable<Object>{
    return this.httpClient.post(`${this.createURL}`, user);
  }

  getUserById(id: number): Observable<any>{

   return this.httpClient.get<any>(`${this.listURL}/${id}`);
  }

  updateUser(id: number, user: User): Observable<Object>{
    return this.httpClient.put(`${this.listURL}/${id}`, user);
  }
}
