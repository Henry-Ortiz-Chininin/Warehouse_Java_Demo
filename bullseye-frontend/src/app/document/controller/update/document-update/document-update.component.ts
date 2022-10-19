import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BullsEyeDocument } from 'src/app/document/model/bullseyedocument';
import { DocumentService } from 'src/app/document/service/document.service';
import { Warehouse } from 'src/app/warehouse/model/warehouse';

@Component({
  selector: 'app-document-update',
  templateUrl: './document-update.component.html',
  styleUrls: ['./document-update.component.css']
})
export class DocumentUpdateComponent implements OnInit {

  beDocument: BullsEyeDocument;
  id: number;

  constructor(
    private documentService: DocumentService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.documentService.getWDocumentById(this.id).subscribe(data =>{
      this.beDocument = data.Data;
      console.log(data.Data);
      //console.log(this.beDocument);
    })
    error => console.log(error);
  }

  updateDocument(){
    this.documentService.updateDocument(this.id, this.beDocument).subscribe(data =>{
      console.log(data);
      this.beDocument = new BullsEyeDocument();
      alert("Warehouse update with ID: " + this.id);
      this.goToList();
    })
  }

  goToList(){
    this.router.navigate(["documents"])
  }

  onSubmit(){
    console.log(this.beDocument);
    this.updateDocument();

  }

}
