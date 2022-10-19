import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ClientDispatch } from '../model/client-dispatch';
import { Dispatch } from '../model/dispatch';
import { VirtualDispatch } from '../model/virtual-dispatch';
import { WarehouseDispatch } from '../model/warehouse-dispatch';

@Injectable({
  providedIn: 'root'
})
export class DispatchService {

  private baseURL = environment.baseUrl + "/kardex/dispatch";
  private listURL = this.baseURL + "/list"
  private itemURL = this.baseURL + "/item"
  private clientURL = this.baseURL + "/client"
  private warehouseURL = this.baseURL + "/warehouse"
  private virtualURL = this.baseURL + "/virtual"

  private newItemURL = this.baseURL + "/new"

  constructor(private httpClient: HttpClient) { }


  getNewReception(): Observable<any>{
    return this.httpClient.get<any>(`${this.newItemURL}`);
  }

  getList(): Observable<Dispatch[]>{
    return this.httpClient.get<Dispatch[]>(`${this.listURL}`);
  }

  
  createVirtual(item: VirtualDispatch): Observable<any>{
    return this.httpClient.post(`${this.virtualURL}`, item);
  }

  createWarehouse(item: WarehouseDispatch): Observable<any>{
    return this.httpClient.post(`${this.warehouseURL}`, item);
  }

  createClient(item: ClientDispatch): Observable<any>{
    return this.httpClient.post(`${this.clientURL}`, item);
  }


}
