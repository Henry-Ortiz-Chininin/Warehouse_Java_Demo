import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from './model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseURL = "http://localhost:8080/api/v1/producthandler";
  private listURL = this.baseURL + "/products"
  private createURL = this.baseURL + "/newproduct"

  constructor(private httpClient: HttpClient) { }

  getProductsList(): Observable<Product[]>{
    return this.httpClient.get<Product[]>(`${this.listURL}`);
  }
  createProduct(product: Product): Observable<Object>{
    return this.httpClient.post(`${this.createURL}`, product);
  }

  getProductById(id: number): Observable<any>{

   return this.httpClient.get<any>(`${this.listURL}/${id}`);
  }

  updateProduct(id: number, product: Product): Observable<Object>{
    return this.httpClient.put(`${this.listURL}/${id}`, product);
  }
}
