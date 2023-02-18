"use strict";
class Persona {
    constructor(nombre, edad, telefono) {
        this.telefono = telefono;
        this.edad = 0;
        this.nombre = "";
        this.edad = edad;
        this.nombre = nombre;
    }
    get g_edad() {
        return this.edad;
    }
    set g_edad(edad) {
        this.edad = edad;
    }
}
let p = new Persona("Andrea", 29, "722450046");
p.g_edad = 21;
console.log(p);
let calculo = function (v, a) {
    return v + a;
};
console.log(2, 4);
