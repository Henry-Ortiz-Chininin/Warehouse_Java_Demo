import { ProductCategory } from "./product-category.enum";

export class Product {

  id: number;
	name: string;
	description: string;
	category: string;
	subCategory: ProductCategory;
  unitPrice: number;
  stock: number;
}
