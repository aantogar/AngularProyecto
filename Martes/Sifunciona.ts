console.log("INICIO");
const promesa=new Promise((resolve,reject)=>{
    setTimeout(resolve,1500);
});
/*const promesa=new Promise((resolve,reject)=>{
    setTimeout(reject,1500);
});*/

console.log("MEDIO");
promesa
    .then(()=>console.log("SALE 1"))
    .catch(()=>console.log("ERRORES"))


console.log("FIN");