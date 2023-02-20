import { Component, OnInit } from '@angular/core';
import { Categoria } from '../interfaces/Product';
import { ServiceService } from '../service/service.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { MatDialog } from '@angular/material/dialog';
import { DialogoConfirmacionComponent } from '../dialogo-confirmacion/dialogo-confirmacion.component';
@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit   {
  lCategorias:Categoria[]=[];
  constructor(private conexion:ServiceService, private router:Router,public dialogo: MatDialog){
   
  }
  
  ngOnInit():void{
    this.getLcategorias();
  }
  mostrarDialogo(id:any): void {
    this.dialogo
      .open(DialogoConfirmacionComponent, {
        data: `¿Está seguro que desea eliminar el registro?`
      })
      .afterClosed()
      .subscribe((confirmado: Boolean) => {
        if (confirmado) {
          const datos: Observable<any> = this.conexion.deleteObject('categorias/'+id);
          console.log("Entra en la funcion" +id);
          datos.subscribe(
            (resp:any) => {
              console.log("He eliminado");
              window.location.reload();
            }
            )
          alert("¡Registro elimado!");
        } else {
          alert("No se ha borrado el registro.)");
        }
      });
  }
  getLcategorias():void{
    const dato: Observable<any>=this.conexion.getObject('categorias');
    console.log("entro en el listado");
    dato.subscribe(
      (resp:any)=>{
        let stat:number=resp.status;
        if(stat==200){
          this.lCategorias=resp.data as Categoria[];
          console.log(this.lCategorias);
        };

    });
  }

  deleteCategoria(id:any){
  const datos: Observable<any> = this.conexion.deleteObject('categorias/'+id);
  console.log("Entra en la funcion" +id);
  datos.subscribe(
    (resp:any) => {
      console.log("He eliminado");
      window.location.reload();
    }
    )
  }
  onSubmit(){
    this.router.navigate(['listado']);
  }
  updateCategoria(id:any){
    this.router.navigate(['update/',id]);
  }

}
  



