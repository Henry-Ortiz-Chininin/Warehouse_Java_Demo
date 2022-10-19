import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BullsEyeDocument } from 'src/app/document/model/bullseyedocument';
import { DocumentService } from 'src/app/document/service/document.service';

@Component({
  selector: 'app-document-detail',
  templateUrl: './document-detail.component.html',
  styleUrls: ['./document-detail.component.css']
})
export class DocumentDetailComponent implements OnInit {

  document: BullsEyeDocument;
  id: number;

  constructor(
    private documentService: DocumentService, 
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.documentService.getWDocumentById(this.id).subscribe(data => {
      this.document = data.Data;
      console.log(this.document);
      
    })
    error => console.log(error);
  }



}
