function converterDecimal(numero, numeroCasas){
numeroCasas = numeroCasas || 2;
return parseFloat(numero.toFixed(numeroCasas));
}