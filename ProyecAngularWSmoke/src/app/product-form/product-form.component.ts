import { HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute} from '@angular/router';
import { Categoria } from '../interfaces/Product';
import { ServiceService } from '../service/service.service';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.css']
})
export class ProductFormComponent  {
categoria: Categoria = {id_categoria:0,cat_nombre:"",cat_descripcion:"" };
  
constructor(private conexion: ServiceService, private rout: Router){}
  guardarCategoria(){
    this.conexion.insertObject('categorias',this.categoria).subscribe(dato =>{
      console.log(dato);
      ;
    });
    
  }

  cancelar(){
    console.log(this.categoria);
    this.rout.navigate(['/']);
    
  }
  onSubmit() {

  
  console.log(this.categoria);
    this.guardarCategoria();
    this.rout.navigate(['listado'])
  }
}