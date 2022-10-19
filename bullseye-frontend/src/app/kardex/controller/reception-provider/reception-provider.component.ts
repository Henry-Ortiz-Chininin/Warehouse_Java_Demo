import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { KardexProduct } from '../../model/product';
import { Product } from 'src/app/product/model/product';
import { Reception } from '../../model/reception';
import { Warehouse } from '../../model/warehouse';
import { ReceptionService } from '../../service/reception.service';
import { ProductService } from 'src/app/product/product.service';
import { DatePipe } from '@angular/common';
import { ProviderReception } from '../../model/provider-reception';

@Component({
  selector: 'app-reception-provider',
  templateUrl: './reception-provider.component.html',
  styleUrls: ['./reception-provider.component.css']
})
export class ReceptionProviderComponent implements OnInit {

  today = new Date();
  pipe = new DatePipe('en-US');
  reception: ProviderReception = new ProviderReception();

  products: Product[];
  warehouses: Warehouse[];
  warehousesIN: Warehouse[];
  newProduct: KardexProduct;
  productSelected: Product;

  constructor(private receptionService: ReceptionService, private productService: ProductService, private router: Router ) { }

  ngOnInit(): void {
    let ChangedFormat = this.pipe.transform(this.today, 'YYYY-MM-dd');
    this.reception = new Reception();
    this.reception.OperationDate = ChangedFormat
    console.log(ChangedFormat);
    this.reception.NewProduct= new KardexProduct();
    this.reception.Warehouses = new Array<Warehouse>();
    this.reception.Products = new Array<KardexProduct>();      

    this.getNewReception();
  }



  onChangeProduct(){
    this.productSelected = this.products.find(p=>p.id==this.reception.NewProduct.ProductID); 
    this.reception.NewProduct.ProductName=this.productSelected.name;  

  };

  getNewReception(){
    this.productService.getProductsList().subscribe(data => {
      //console.log(data);
      this.products = data;      
    });

    this.receptionService.getNewReception().subscribe(data => {
      //console.log(data);
      this.warehouses=data.Data.Warehouses;
      this.warehousesIN = this.warehouses.filter(e=>e.Type=="DST");

    });

  }

  save(){
    this.receptionService.createProvider(this.reception).subscribe(data => {
      if(data.Status =="OK"){
        this.reception.KardexID=data.Data;
        alert("Document successfully created")
      }else{
        alert(data.Error.message);
      }
      
    })
  }

  onSubmit(){
    if(this.reception.OperationDate=="") 
    {
      alert("Operation Date is mandatory")
      return;
    }
    if(this.reception.ProviderName=="") 
    {
      alert("Provider name is mandatory")
      return;
    }
    if(this.reception.ToWarehouseID==null) 
    {
      alert("Warehouseis mandatory")
      return;
    }
    if(this.reception.Products.length==0) 
    {
      alert("Outgoing products are mandatory")
      return;
    }

    this.save();
  }

  
  onAddProduct(){
    if(this.reception.NewProduct.ProductID==null) 
    {
      alert("Select a product to add")
      return;
    }
    if(this.reception.NewProduct.Quantity==null || this.reception.NewProduct.Quantity==0) 
    {
      alert("Quantity of products is mandatory")
      return;
    }
    if(this.reception.NewProduct.TotalPrice==null || this.reception.NewProduct.TotalPrice==0) 
    {
      alert("Total amount for products is mandatory")
      return;
    }

    this.newProduct=new KardexProduct();
    this.newProduct.ProductID=this.reception.NewProduct.ProductID;
    this.newProduct.ProductName=this.reception.NewProduct.ProductName;
    this.newProduct.Quantity=this.reception.NewProduct.Quantity;
    this.newProduct.UnitPrice=this.reception.NewProduct.UnitPrice;
    this.newProduct.TotalPrice=this.reception.NewProduct.TotalPrice;
    
    this.reception.Products.push(this.newProduct);
    this.newProduct=null;
  }

  onRemoveProduct(id:number){
    this.reception.Products.forEach((obj, index)=>{
      if(obj.ProductID==id){
        this.reception.Products.splice(index,1);
      }
    });
  }
}
