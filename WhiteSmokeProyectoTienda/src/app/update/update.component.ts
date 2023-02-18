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
  id:number=0;
  categoria: Categoria={id_categoria:0,cat_nombre:"",cat_descripcion:""};
  


    constructor(private servic: ServiceService, private route: ActivatedRoute, private router: Router){}
    ngOnInit(): void {
      this.getParam();
    if (this.id>0){
      const dato: Observable<any> = this.servic.getObject('categorias');
      console.log(this.getParam());
      dato.subscribe(
        (resp: any) => {
          if(resp.status==200){
            this.categoria = resp.data as Categoria;
          }
        })
    }
  }

  updateCat(): void{
    let obs: Observable<any> = this.servic.updateObject('categorias',this.categoria);
    obs.subscribe((resp: any) => {
      let stats: number = resp.status;
      if(stats == 200){
        console.log("Registro actualizado");
      }
    })
    this.router.navigateByUrl('categorias')
  }

  getParam():void{
    this.id = Number(this.route.snapshot.paramMap.get('id'));
    }
    onSubmit(){
      console.log(this.categoria);
      this.updateCat();
      this.router.navigate(['listado']);
      
    }
  }

  
  


