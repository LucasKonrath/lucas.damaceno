modulo.factory("imovelService", function ($http) {
    return ({
        obterImoveis: obterImoveis,
        obterTamanhos: obterTamanhos,
        obterAdicionais: obterAdicionais
        
    });

    function obterImoveis() {
        return $http.get('http://localhost:55508/api/tipoImovel/obterImoveis');
    }
    
    function obterTamanhos(id){
        
        return  $http.get('http://localhost:55508/api/tipoImovel/obterTamanhosDoImovel/'+ id +'');
    }
    function obterAdicionais(){
    
        return $http.get('http://localhost:55508/api/adicionais');

    }
});