import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../model/product';
import { ProductCategory } from '../model/product-category.enum';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {

  product: Product = new Product();
  category = ProductCategory;
  constructor(private productService: ProductService, private router: Router) { }

  ngOnInit(): void {
  }
  saveProduct(){
    this.productService.createProduct(this.product).subscribe( data => {
     console.log(data);
     this.goToProductList();
    },
    error => console.log(error));

  }
  goToProductList(){
    this.router.navigate(['/products']);

  }
  onSubmit(){
    console.log(this.product);
    this.saveProduct();

  }

}
