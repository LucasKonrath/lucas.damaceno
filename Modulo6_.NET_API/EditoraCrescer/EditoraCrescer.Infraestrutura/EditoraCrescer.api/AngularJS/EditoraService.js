modulo.factory("editoraService", function ($http) {
    return ({
        obterLivros: obterLivros,
        obterLancamentos: obterLancamentos
    });

    function obterLivros() {
        return $http.get("http://localhost:63773/api/Livros");
    }
    
    function obterLancamentos() {
        return $http.get("http://localhost:63773/api/Livros/Lancamentos");
    }

   
});