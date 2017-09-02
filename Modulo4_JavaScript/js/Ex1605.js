function converterDecimal(numero, numeroCasas){
if(numeroCasas !== 0){
numeroCasas =  numeroCasas || 2;
}
return parseFloat(numero.toFixed(numeroCasas));
}

Number.prototype.arredondar = function converterComPow(numeroCasas){
if(numeroCasas !== 0){
numeroCasas =  numeroCasas || 2;
}
 return Math.round(this * Math.pow(10,numeroCasas))/Math.pow(10,numeroCasas);
}

