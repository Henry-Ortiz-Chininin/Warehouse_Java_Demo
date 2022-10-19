import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Warehouse } from '../model/warehouse';

@Injectable({
  providedIn: 'root'
})
export class WarehouseService {
  private baseUrl = "http://localhost:8080/api/v1/warehousehandler";
  private listUrl = this.baseUrl + "/warehouses";
  private createUrl = this.baseUrl + "/newwarehouse";
  private updateUrl = this.baseUrl + "/warehouse";


  constructor(private httpClient: HttpClient) { }

  getWarehousesList(): Observable<Warehouse[]>{
    return this.httpClient.get<Warehouse[]>(`${this.listUrl}`);
  }

  createWarehouse(warehouse: Warehouse): Observable<Object>{
    return this.httpClient.post(`${this.createUrl}`, warehouse)
  }

  getWarehouseById(id: number): Observable<any>{
    return this.httpClient.get<any>(`${this.updateUrl}/${id}`);
  }

  updateWarehouse(id: number, warehouse: Warehouse): Observable<Object>{
    return this.httpClient.put(`${this.updateUrl}/${id}`, warehouse);
  }


}
