import { KardexProduct } from "./product";
import { Warehouse } from "./warehouse";

export class WarehouseReception {
    KardexID:number;
    OperationDate: string;
	WaybillNumber: string;
    RequestNumber: string;

    FromWarehouseID: number;
	ToWarehouseID: number;

    NewProduct: KardexProduct;
	
	
	Warehouses: Array<Warehouse>;
	Products: Array<KardexProduct>;
	
}
