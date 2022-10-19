import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserListComponent } from './user/user-list/user-list.component';
import { UserLoginComponent } from './login/user-login/user-login.component';
import { HomeComponent } from './home/home.component';

import { WarehouseListComponent } from './warehouse/controller/list/warehouse-list/warehouse-list.component';
import { WarehouseDetailComponent } from './warehouse/controller/detail/warehouse-detail/warehouse-detail.component';
import { WarehouseCreateComponent } from './warehouse/controller/create/warehouse-create/warehouse-create.component';
import { WarehouseUpdateComponent } from './warehouse/controller/update/warehouse-update/warehouse-update.component';

import { UserCreateComponent } from './user/user-create/user-create.component';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { UserUpdateComponent } from './user/user-update/user-update.component';
import { ProductListComponent } from './product/product-list/product-list.component';
import { ProductCreateComponent } from './product/product-create/product-create.component';
import { ProductUpdateComponent } from './product/product-update/product-update.component';
import { MovementListComponent } from './movement/controller/list/movement-list/movement-list.component';
import { MovementCreateComponent } from './movement/controller/create/movement-create/movement-create.component';
import { MovementUpdateComponent } from './movement/controller/update/movement-update/movement-update.component';
import { MovementDetailComponent } from './movement/controller/detail/movement-detail/movement-detail.component';
import { DocumentCreateComponent } from './document/controller/create/document-create/document-create.component';
import { DocumentUpdateComponent } from './document/controller/update/document-update/document-update.component';
import { DocumentListComponent } from './document/controller/list/document-list/document-list.component';
import { DocumentDetailComponent } from './document/controller/detail/document-detail/document-detail.component';
import { DispatchComponent } from './kardex/controller/dispatch/dispatch.component';
import { ReceptionComponent } from './kardex/controller/reception/reception.component';
import { ReceptionVirtualComponent } from './kardex/controller/reception-virtual/reception-virtual.component';
import { ReceptionProviderComponent } from './kardex/controller/reception-provider/reception-provider.component';
import { DispatchVirtualComponent } from './kardex/controller/dispatch-virtual/dispatch-virtual.component';
import { DispatchClientComponent } from './kardex/controller/dispatch-client/dispatch-client.component';



@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    UserLoginComponent,
    HomeComponent,
    UserCreateComponent,
    UserUpdateComponent,
    ProductListComponent,
    ProductCreateComponent,
    ProductUpdateComponent,
    WarehouseListComponent,
    WarehouseDetailComponent,
    WarehouseCreateComponent,
    WarehouseUpdateComponent,
    MovementListComponent,
    MovementCreateComponent,
    MovementUpdateComponent,
    MovementDetailComponent,
    DocumentCreateComponent,
    DocumentUpdateComponent,
    DocumentListComponent,
    DocumentDetailComponent,
    DispatchComponent,
    ReceptionComponent,
    ReceptionVirtualComponent,
    ReceptionProviderComponent,
    DispatchVirtualComponent,
    DispatchClientComponent


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
