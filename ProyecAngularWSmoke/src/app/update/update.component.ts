import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categoria } from '../interfaces/Product';
import { ServiceService } from '../service/service.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  id:number = 0;
  categoria:Categoria={id_categoria:0, cat_nombre:"", cat_descripcion:""}

  constructor(private conexion: ServiceService, private router:Router, private route:ActivatedRoute){
    this.getParam();
    if (this.id>0){
      const dato: Observable<any> = this.conexion.getObject('categorias/'+this.id);
      console.log(this.getParam());
      dato.subscribe(
        (resp: any) => {
          if(resp.status==200){
            this.categoria = resp.data as Categoria;
          }
        })
    }
  }

  getParam():void{
    this.id = Number(this.route.snapshot.paramMap.get('id'));
  }

  ngOnInit(){
  }

  modificar(): void{
    let obs: Observable<any> = this.conexion.updateObject('categorias', this.categoria);
    obs.subscribe((resp: any) => {
      let stats: number = resp.status;
      if(stats == 200){
        console.log("Modificado");
      }
      this.router.navigate(['listado'])
    })
    

  }
  
}