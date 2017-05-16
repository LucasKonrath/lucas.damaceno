function converterDecimal(numero, numeroCasas){
if(numeroCasas !== 0){
numeroCasas =  numeroCasas || 2;
}
return parseFloat(numero.toFixed(numeroCasas));
}