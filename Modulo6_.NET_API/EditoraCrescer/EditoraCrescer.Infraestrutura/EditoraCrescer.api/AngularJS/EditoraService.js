modulo.factory("editoraService", function ($http) {
    return ({
        obterLivros: obterLivros,
        obterLancamentos: obterLancamentos,
        obterLivrosParametros: obterLivrosParametros,
        obterLivroPorID: obterLivroPorID,
        atualizarLivro:atualizarLivro,
        removerLivro:removerLivro,
        criarLivro:criarLivro,
        revisarLivro: revisarLivro,
        publicarLivro: publicarLivro
        
    });

    function obterLivros() {
        return $http.get("http://localhost:63773/api/Livros");
    }

    function obterLivrosParametros(pegar, pular) {
        return $http.get('http://localhost:63773/api/Livros/' + pegar + '/' + pular +'');
    }


    function obterLancamentos() {
        return $http.get("http://localhost:63773/api/Livros/Lancamentos");
    }
    function obterLivroPorID(id){
        return $http.get("http://localhost:63773/api/livros/" + id + "");
    }

    function criarLivro(livro){

        return $http.post("http://localhost:63773/api/livros/", livro);

    }

    function revisarLivro(id){
        return $http.put("http://localhost:63773/api/livros/revisar/" + id +"");
        
    }
    
    function publicarLivro(id){
        return $http.put("http://localhost:63773/api/livros/publicar/" + id +"");
        
    }
    
    function removerLivro(id){

        return $http.delete("http://localhost:63773/api/livros/" + id +"");
    }

    function atualizarLivro(livro) {
        return $http.put("http://localhost:63773/api/livros/" + livro.Isbn, livro);
    }

});