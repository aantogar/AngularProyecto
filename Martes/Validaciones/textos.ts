const MENSAJES: string[] =[
    "Este es el primer mensaje",
    "Este es el segundo mensaje"];

export function obtenerError(numError:number):string{
    return MENSAJES[numError];
}