import { KardexProduct } from "./product";
import { Warehouse } from "./warehouse";

export class VirtualDispatch {
    KardexID:number;
    OperationDate: string;
	WaybillNumber: string;
	RequestNumber: string;

	FromWarehouseID: number;
    
	ToVirtualStoreID: number;

	NewProduct: KardexProduct;
	
	Warehouses: Array<Warehouse>;
	Products: Array<KardexProduct>;
}
