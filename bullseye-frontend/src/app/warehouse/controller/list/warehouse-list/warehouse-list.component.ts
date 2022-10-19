import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Warehouse } from 'src/app/warehouse/model/warehouse';
import { WarehouseService } from 'src/app/warehouse/service/warehouse.service';

@Component({
  selector: 'app-warehouse-list',
  templateUrl: './warehouse-list.component.html',
  styleUrls: ['./warehouse-list.component.css']
})
export class WarehouseListComponent implements OnInit {

  warehouses: Warehouse[];

  constructor(private warehouseService: WarehouseService, private router: Router) { }

  ngOnInit(): void {
    this.getWarehouses();
    console.log(this.warehouses);
  }

  private getWarehouses(){
    this.warehouseService.getWarehousesList().subscribe(data => {

      this.warehouses = data;
      console.log(this.warehouses);

    });
  }

  updateWarehouse(id: number){
    this.router.navigate(['warehouse-update', id]);

  }

  viewWarehouseDetials(id: number){
    this.router.navigate(['warehouse-detail', id]);

  }

}
