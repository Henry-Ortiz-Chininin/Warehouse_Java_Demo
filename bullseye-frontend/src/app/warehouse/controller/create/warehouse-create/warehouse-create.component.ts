import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Warehouse } from 'src/app/warehouse/model/warehouse';
import { WarehouseService } from 'src/app/warehouse/service/warehouse.service';

@Component({
  selector: 'app-warehouse-create',
  templateUrl: './warehouse-create.component.html',
  styleUrls: ['./warehouse-create.component.css']
})
export class WarehouseCreateComponent implements OnInit {

  warehouse: Warehouse = new Warehouse();

  constructor(private warehouseService: WarehouseService, private router: Router) { }

  ngOnInit(): void {
  }

  saveWarehouse(){
    this.warehouseService.createWarehouse(this.warehouse).subscribe(data => {
      console.log(data);
      alert(`Warehouse successfully created`)
      this.goToList();
      
    })
  }

  onSubmit(){
    console.log(this.warehouse);
    this.saveWarehouse();
  }

  goToList(){
    this.router.navigate(['/warehouses'])
  }



}
