import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Product } from '../model/product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {

  id: number;
  product: Product =  new Product();
  constructor(private productService: ProductService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {

    this.id =  this.route.snapshot.params['id'];
    this.productService.getProductById(this.id)
    .subscribe(data => {
       this.product= data.Data;

       console.log(this.product);

    }, error => console.log(error));

  }
  onSubmit(){
    this.productService.updateProduct(this.id, this.product).subscribe ( data =>{
      this.goToUserList();
    },
    error => console.log(error));

  }
  goToUserList(){
    this.router.navigate(['/products']);

  }

}
