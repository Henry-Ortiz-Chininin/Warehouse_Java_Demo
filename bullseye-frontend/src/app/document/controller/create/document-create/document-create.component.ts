import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BullsEyeDocument } from 'src/app/document/model/bullseyedocument';
import { DocumentService } from 'src/app/document/service/document.service';

@Component({
  selector: 'app-document-create',
  templateUrl: './document-create.component.html',
  styleUrls: ['./document-create.component.css']
})
export class DocumentCreateComponent implements OnInit {

  document: BullsEyeDocument = new BullsEyeDocument();

  constructor(private documentService: DocumentService, private router: Router ) { }

  ngOnInit(): void {
  }

  saveDocument(){
    this.documentService.createDocument(this.document).subscribe(data => {
      console.log(data);
      alert("Document successfully created")
      this.goToList();
      
    })
  }

  onSubmit(){
    console.log(this.document);
    this.saveDocument();
  }

  goToList(){
    this.router.navigate(['/documents']);
  }

}
