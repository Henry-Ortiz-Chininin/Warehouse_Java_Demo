import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BullsEyeDocument } from '../model/bullseyedocument';

@Injectable({
  providedIn: 'root'
})
export class DocumentService {
  private baseUrl = "http://localhost:8080/api/v1/documenthandler"
  private listUrl = this.baseUrl + "/documents";
  private createUrl = this.baseUrl + "/newdocument";
  private updateUrl = this.baseUrl + "/document";

  constructor(private httpClient: HttpClient) {  }

  getDocumentList(): Observable<BullsEyeDocument[]>{
      return this.httpClient.get<BullsEyeDocument[]>(`${this.listUrl}`);
  }

  createDocument(document: BullsEyeDocument): Observable<Object>{
    return this.httpClient.post(`${this.createUrl}`, document);
  }

  getWDocumentById(id: number): Observable<any>{
    return this.httpClient.get<any>(`${this.updateUrl}/${id}`);
  }

  updateDocument(id: number, document: BullsEyeDocument): Observable<Object>{
    return this.httpClient.put(`${this.updateUrl}/${id}`, document);
  }
}
