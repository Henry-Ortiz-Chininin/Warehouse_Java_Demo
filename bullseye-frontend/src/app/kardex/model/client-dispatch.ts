import { KardexProduct } from "./product";
import { Warehouse } from "./warehouse";

export class ClientDispatch {
    KardexID:number;
    OperationDate: string;
	InvoiceNumber: string;
	ClientName: string;

	FromWarehouseID: number;

	NewProduct: KardexProduct;
	
	Warehouses: Array<Warehouse>;

    Products: Array<KardexProduct>;
}
