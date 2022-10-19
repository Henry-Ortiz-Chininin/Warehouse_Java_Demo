import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ProductCreateComponent } from './product/product-create/product-create.component';
import { ProductListComponent } from './product/product-list/product-list.component';
import { ProductUpdateComponent } from './product/product-update/product-update.component';
import { UserCreateComponent } from './user/user-create/user-create.component';
import { UserListComponent } from './user/user-list/user-list.component';
import { WarehouseCreateComponent } from './warehouse/controller/create/warehouse-create/warehouse-create.component';
import { WarehouseDetailComponent } from './warehouse/controller/detail/warehouse-detail/warehouse-detail.component';
import { WarehouseListComponent } from './warehouse/controller/list/warehouse-list/warehouse-list.component';
import { WarehouseUpdateComponent } from './warehouse/controller/update/warehouse-update/warehouse-update.component';
import { UserUpdateComponent } from './user/user-update/user-update.component';

import { UserLoginComponent } from './login/user-login/user-login.component';

import { DocumentListComponent } from './document/controller/list/document-list/document-list.component';
import { DocumentCreateComponent } from './document/controller/create/document-create/document-create.component';
import { DocumentUpdateComponent } from './document/controller/update/document-update/document-update.component';
import { DocumentDetailComponent } from './document/controller/detail/document-detail/document-detail.component';
import { DispatchComponent } from './kardex/controller/dispatch/dispatch.component';
import { ReceptionComponent } from './kardex/controller/reception/reception.component';
import { DispatchVirtualComponent } from './kardex/controller/dispatch-virtual/dispatch-virtual.component';
import { DispatchClientComponent } from './kardex/controller/dispatch-client/dispatch-client.component';
import { ReceptionProviderComponent } from './kardex/controller/reception-provider/reception-provider.component';
import { ReceptionVirtualComponent } from './kardex/controller/reception-virtual/reception-virtual.component';

import { VirtualDispatch } from './kardex/model/virtual-dispatch';


const routes: Routes = [
  {path: '', redirectTo:'/home',pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'login', component: UserLoginComponent},
  {path: 'users', component: UserListComponent},
  {path: 'newuser', component: UserCreateComponent},
  {path: 'user-update/:id', component: UserUpdateComponent},
  {path: 'products', component: ProductListComponent},
  {path: 'newproduct', component: ProductCreateComponent},
  {path: 'product-update/:id', component: ProductUpdateComponent},
  {path: 'warehouses', component: WarehouseListComponent},
  {path: 'warehouse-update/:id', component: WarehouseUpdateComponent},
  {path: 'warehouse-create', component: WarehouseCreateComponent},
  {path: 'warehouse-detail/:id', component: WarehouseDetailComponent},
  {path: 'documents', component: DocumentListComponent},
  {path: 'document-create', component: DocumentCreateComponent},
  {path: 'document-update/:id', component: DocumentUpdateComponent},
  {path: 'document-detail/:id', component: DocumentDetailComponent},

  {path: 'virtual-dispatch', component: DispatchVirtualComponent},
  {path: 'client-dispatch', component: DispatchClientComponent},
  {path: 'warehouse-dispatch', component: DispatchComponent},

  {path: 'virtual-reception', component: ReceptionVirtualComponent},
  {path: 'provider-reception', component: ReceptionProviderComponent},
  {path: 'warehouse-reception', component: DispatchComponent},

  {path: 'kardex-reception', component: ReceptionComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
