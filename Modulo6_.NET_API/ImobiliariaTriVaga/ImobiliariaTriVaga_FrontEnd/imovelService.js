modulo.factory("imovelService", function ($http) {
    return ({
        obterImoveis: obterImoveis,
        obterTamanhos: obterTamanhos,
        obterAdicionais: obterAdicionais,
        gerarPedido: gerarPedido,
        obterPedido: obterPedido,
        excluirPedido: excluirPedido

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

    function gerarPedido(pedido){

        return $http.post('http://localhost:55508/api/pedidos/criar',pedido);

    }

    function obterPedido(id){

        return $http.get('http://localhost:55508/api/pedidos/obter/'+id);
    }
    
    function excluirPedido(id){
        
        return $http.delete('http://localhost:55508/api/pedidos/deletar/' + id);
    }
    
    function devolverPedido(id){
        
    }
});