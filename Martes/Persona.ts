class Persona{
    edad:number=0;
    nombre:string="";

    constructor(nombre:string,edad:number,private telefono:string){
        this.edad=edad;
        this.nombre=nombre;
    }
get g_edad(){
    return this.edad;
    }
set g_edad(edad:number){
    this.edad=edad;
    }
}
/**
 * Interface y luego se implementa 
 */
interface Movimiento{
    (vinit:number,acc:number):number;}
let p:Persona=new Persona("Andrea",29,"722450046");
    p.g_edad=21;
    console.log(p);
    let calculo:Movimiento=function(v:number,a:number){
        return v+a;
    }
    console.log(2,4);
    



