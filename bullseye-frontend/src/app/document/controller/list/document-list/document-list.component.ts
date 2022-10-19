import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BullsEyeDocument } from 'src/app/document/model/bullseyedocument';
import { DocumentService } from 'src/app/document/service/document.service';

@Component({
  selector: 'app-document-list',
  templateUrl: './document-list.component.html',
  styleUrls: ['./document-list.component.css']
})
export class DocumentListComponent implements OnInit {
  documents: BullsEyeDocument[];
  constructor(
    private documentService: DocumentService,
    private router: Router
    ) { }

  ngOnInit(): void {
    this.getDocuments();
    console.log(this.documents);

  }

  private getDocuments(){
    this.documentService.getDocumentList().subscribe(data =>{
      this.documents = data;
    })
  }

  updateDocument(id: number){
    this.router.navigate(['document-update', id]);
  }

  viewDocumentDetails(id: number){
    this.router.navigate(['document-detail', id]);
  }

}
