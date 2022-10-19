import { KardexProduct } from "./product";
import { Warehouse } from "./warehouse";

export class Dispatch {
	KardexID:number;
    OperationDate: string;
	WaybillNumber: string;
	InvoiceNumber: string;
	RequestNumber: string;
	ClientName: string;

	FromWarehouseID: number;
	ToWarehouseID: number;
	ToVirtualStoreID: number;

	NewProduct: KardexProduct;
	
	Warehouses: Array<Warehouse>;
	Products: Array<KardexProduct>;
	
}
