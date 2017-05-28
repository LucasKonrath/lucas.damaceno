modulo.factory("chatService", function ($http) {
    return ({
        obterMensagens: obterMensagens,
        enviarMensagem: enviarMensagem
    });

    function obterMensagens() {
        return $http.get("http://localhost:52476/api/Chat");
    }

    function enviarMensagem(nomeAutor,fotoAutor,textoMensagem ) {
        return $http({
            method: "post",
            url: "http://localhost:52476/api/Chat",
            data: {
                "Id":9999,
                "CorpoMensagem": textoMensagem,
                "NomeUsuario": nomeAutor,
                "FotoUrlUsuario": fotoAutor
            }
        });
    }
});