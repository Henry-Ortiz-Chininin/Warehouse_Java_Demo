import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Warehouse } from 'src/app/warehouse/model/warehouse';
import { WarehouseService } from 'src/app/warehouse/service/warehouse.service';

@Component({
  selector: 'app-warehouse-update',
  templateUrl: './warehouse-update.component.html',
  styleUrls: ['./warehouse-update.component.css']
})
export class WarehouseUpdateComponent implements OnInit {

  warehouse: Warehouse = new Warehouse();
  id: number

  constructor(
    private warehouseService: WarehouseService, 
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.warehouseService.getWarehouseById(this.id).subscribe(data => {
      this.warehouse = data.Data;
      console.log(this.warehouse);
    })
    error => console.log(error);
  }

  updateWarehouse(){
    this.warehouseService.updateWarehouse(this.id, this.warehouse)
    .subscribe(data => {
      console.log(data);
      this.warehouse = new Warehouse();
      alert("Warehouse update with ID: " + this.id);
      this.goToList();
    }
    );
  }

  goToList(){
    this.router.navigate(['/warehouses'])

  }

  onSubmit(){
    console.log(this.warehouse);
    this.updateWarehouse();
  }

}
