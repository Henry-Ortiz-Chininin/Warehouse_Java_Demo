import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Reception } from '../model/reception';
import { VirtualReception } from '../model/virtual-reception';
import { WarehouseReception } from '../model/warehouse-reception';
import { ProviderReception } from '../model/provider-reception';

@Injectable({
  providedIn: 'root'
})
export class ReceptionService {

  private baseURL = environment.baseUrl + "/kardex/reception";
  private listURL = this.baseURL + "/list"
  private providerURL = this.baseURL + "/provider"
  private warehouseURL = this.baseURL + "/warehouse"
  private virtualURL = this.baseURL + "/virtual"
  private newItemURL = this.baseURL + "/new"

  constructor(private httpClient: HttpClient) { }


  getNewReception(): Observable<any>{
    return this.httpClient.get<any>(`${this.newItemURL}`);
  }

  getList(): Observable<Reception[]>{
    return this.httpClient.get<Reception[]>(`${this.listURL}`);
  }


  createVirtual(item: VirtualReception): Observable<any>{
    return this.httpClient.post(`${this.virtualURL}`, item);
  }

  createWarehouse(item: WarehouseReception): Observable<any>{
    return this.httpClient.post(`${this.warehouseURL}`, item);
  }

  createProvider(item: ProviderReception): Observable<any>{
    return this.httpClient.post(`${this.providerURL}`, item);
  }

}
