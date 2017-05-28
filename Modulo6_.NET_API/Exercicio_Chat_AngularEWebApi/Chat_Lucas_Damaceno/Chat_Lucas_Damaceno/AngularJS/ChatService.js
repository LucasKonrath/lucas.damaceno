modulo.factory("chatService", function ($http) {
    return ({
        obterMensagens: obterMensagens,
        enviarMensagem: enviarMensagem
    });

    function obterMensagens() {
        return $http.get("http://localhost:52476/api/Chat");
    }

    function enviarMensagem() {
        return $http({
            method: "post",
            url: "http://localhost:52476/api/Chat",
            data: {
                "Id": 9,
                "CorpoMensagem": "Vi Veri Veniversum Vivus Vici.",
                "NomeUsuario": "V",
                "FotoUrlUsuario": "https://i.ytimg.com/vi/8WZ0XSf23rs/maxresdefault.jpg"
            }
        });
    }
});