import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Categoria } from './interfaces/Product';
import { ServiceService } from './service/service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ProyecAngularWSmoke';
  listado: Categoria[]=[];
  constructor(private conexion: ServiceService){
    const dato: Observable<any>=this.conexion.getObject('categorias');
    console.log("entro en el listado");
    dato.subscribe(
      (resp:any)=>{
        let stat:number=resp.status;
        if(stat==200){
          this.listado=resp.data as Categoria[];
          console.log(this.listado);
        };

      }
    )
    
  }
}


