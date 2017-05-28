var modulo = angular.module('chatApp', []);

modulo.controller('ChatController', function ($scope, chatService) {
    $scope.mensagens = {};
    $scope.enviarMensagem = enviarMensagem;
    $scope.obterMensagens = obterMensagens;    
    $scope.enviarUser = enviarUser;
    usuarioCadastrado = localStorage.getItem("nomeUser") !== null;
    $scope.usuarioCadastrado = usuarioCadastrado;
    setInterval(function(){ obterMensagens(); }, 3000);
    
    function enviarUser() {
        
        localStorage.setItem("nomeUser",$scope.nomeUser);
        localStorage.setItem("fotoUser",$scope.imagemUser);
        $scope.usuarioCadastrado = true;
    }
    
    
    function obterMensagens() {
        chatService
        .obterMensagens()
        .then(response => {
            console.log(response);
            $scope.mensagens = response.data;
        })
    }

    function enviarMensagem() {
        chatService
        .enviarMensagem(localStorage.getItem("nomeUser"), localStorage.getItem("fotoUser"), $scope.textoMensagem)
        .then(mensagens => {
            obterMensagens();
        })
    }
});