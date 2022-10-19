import { KardexProduct } from "./product";
import { Warehouse } from "./warehouse";

export class ProviderReception {
    KardexID:number;
    OperationDate: string;
	WaybillNumber: string;

    PurchaseOrder: string;

    ProviderName: string;

	ToWarehouseID: number;

    NewProduct: KardexProduct;
	
	Warehouses: Array<Warehouse>;
	Products: Array<KardexProduct>;
	
}
