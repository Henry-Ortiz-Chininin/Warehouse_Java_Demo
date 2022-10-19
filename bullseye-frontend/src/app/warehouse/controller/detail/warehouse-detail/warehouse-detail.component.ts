import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Warehouse } from 'src/app/warehouse/model/warehouse';
import { WarehouseService } from 'src/app/warehouse/service/warehouse.service';

@Component({
  selector: 'app-warehouse-detail',
  templateUrl: './warehouse-detail.component.html',
  styleUrls: ['./warehouse-detail.component.css']
})
export class WarehouseDetailComponent implements OnInit {

  warehouse: Warehouse = new Warehouse();
  id: number;

  constructor(private warehouseService: WarehouseService, private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.warehouseService.getWarehouseById(this.id).subscribe(data => {
      this.warehouse = data.Data;
      console.log(this.warehouse);
    })
    error => console.log(error);
  }

}
