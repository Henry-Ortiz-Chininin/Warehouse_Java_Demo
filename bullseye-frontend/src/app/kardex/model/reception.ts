import { KardexProduct } from "./product";
import { Warehouse } from "./warehouse";

export class Reception {
	KardexID:number;
    OperationDate: string;
	WaybillNumber: string;
	InvoiceNumber: string;
	PurchaseOrder: string;
	RequestNumber: string;
	ProviderName: string;
	FromWarehouseID: number;
	ToWarehouseID: number;
	NewProduct: KardexProduct;
	
	
	Warehouses: Array<Warehouse>;
	Products: Array<KardexProduct>;
	
}
