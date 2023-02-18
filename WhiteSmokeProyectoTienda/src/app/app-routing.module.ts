import { NgModule } from '@angular/core';
import { NavigateComponent } from './navigate/navigate.component';
import { RouterModule, Routes } from '@angular/router';
import { ProductFormComponent } from './product-form/product-form.component';
import { ProductListComponent } from './product-list/product-list.component';
import { UpdateComponent } from './update/update.component';

const routes: Routes = [
 
 {path:'categorias', component:ProductFormComponent},
 {path:'listado', component:ProductListComponent},
 {path: 'update/:id', component:UpdateComponent},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
