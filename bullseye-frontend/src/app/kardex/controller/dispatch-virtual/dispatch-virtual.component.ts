import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { KardexProduct } from '../../model/product';
import { Product } from 'src/app/product/model/product';
import { Warehouse } from '../../model/warehouse';
import { ProductService } from 'src/app/product/product.service';
import { DatePipe } from '@angular/common';
import { Dispatch } from '../../model/dispatch';
import { DispatchService } from '../../service/dispatch.service';
import { VirtualDispatch } from '../../model/virtual-dispatch';

@Component({
  selector: 'app-dispatch-virtual',
  templateUrl: './dispatch-virtual.component.html',
  styleUrls: ['./dispatch-virtual.component.css']
})
export class DispatchVirtualComponent implements OnInit {


  today = new Date();
  pipe = new DatePipe('en-US');
  dispatch: VirtualDispatch = new VirtualDispatch();

  products: Product[];
  warehouses: Warehouse[];
  warehousesIN: Warehouse[];
  warehousesOUT: Warehouse[];
  productSelected: Product;
  newProduct: KardexProduct;


  constructor(private dispatchService: DispatchService, private productService: ProductService, private router: Router ) { }

  ngOnInit(): void {
    let ChangedFormat = this.pipe.transform(this.today, 'YYYY-MM-dd');
    this.dispatch = new Dispatch();
    this.dispatch.OperationDate = ChangedFormat
    console.log(ChangedFormat);
    this.dispatch.NewProduct= new KardexProduct();
    this.dispatch.Warehouses = new Array<Warehouse>();
    this.dispatch.Products = new Array<KardexProduct>();

    this.getNewReception();
  }



  onChangeProduct(){
    this.productSelected = this.products.find(p=>p.id==this.dispatch.NewProduct.ProductID);
    this.dispatch.NewProduct.ProductName=this.productSelected.name;

  };

  getNewReception(){
    this.productService.getProductsList().subscribe(data => {
      //console.log(data);
      this.products = data;
    });

    this.dispatchService.getNewReception().subscribe(data => {
      //console.log(data);
      this.warehouses=data.Data.Warehouses;
      this.warehousesIN = this.warehouses.filter(e=>e.Type=="VRT");
      this.warehousesOUT = this.warehouses.filter(e=>e.Type!="VRT");


      //this.reception = data.Data;        
    });

  }

  save(){
    this.dispatchService.createVirtual(this.dispatch).subscribe(data => {
      if(data.Status =="OK"){
        this.dispatch.KardexID=data.Data;
        alert("Document successfully created")
      }else{
        alert(data.Error.message);
      }

    })
  }

  onSubmit(){
   if(this.dispatch.OperationDate=="") 
    {
      alert("Operation Date is mandatory")
      return;
    }
    if(this.dispatch.FromWarehouseID==null) 
    {
      alert("Warehouse Origin is mandatory")
      return;
    }
    if(this.dispatch.ToVirtualStoreID==null) 
    {
      alert("Warehouse Destination is mandatory")
      return;
    }
    if(this.dispatch.Products.length==0) 
    {
      alert("Outgoing products are mandatory")
      return;
    }
    this.save();
  }


  onAddProduct(){
    if(this.dispatch.NewProduct.ProductID==null) 
    {
      alert("Select a product to add")
      return;
    }
    if(this.dispatch.NewProduct.Quantity==null || this.dispatch.NewProduct.Quantity==0) 
    {
      alert("Quantity of products is mandatory")
      return;
    }
    if(this.dispatch.NewProduct.TotalPrice==null || this.dispatch.NewProduct.TotalPrice==0) 
    {
      alert("Total amount for products is mandatory")
      return;
    }

    this.newProduct=new KardexProduct();
    this.newProduct.ProductID=this.dispatch.NewProduct.ProductID;
    this.newProduct.ProductName=this.dispatch.NewProduct.ProductName;
    this.newProduct.Quantity=this.dispatch.NewProduct.Quantity;
    this.newProduct.UnitPrice=this.dispatch.NewProduct.UnitPrice;
    this.newProduct.TotalPrice=this.dispatch.NewProduct.TotalPrice;
    
    this.dispatch.Products.push(this.newProduct);
    this.newProduct=null;
  }

  onRemoveProduct(id:number){
    this.dispatch.Products.forEach((obj, index)=>{
      if(obj.ProductID==id){
        this.dispatch.Products.splice(index,1);
      }
    });
  }

}
