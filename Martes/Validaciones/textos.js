"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.obtenerError = void 0;
const MENSAJES = [
    "Este es el primer mensaje",
    "Este es el segundo mensaje"
];
function obtenerError(numError) {
    return MENSAJES[numError];
}
exports.obtenerError = obtenerError;
