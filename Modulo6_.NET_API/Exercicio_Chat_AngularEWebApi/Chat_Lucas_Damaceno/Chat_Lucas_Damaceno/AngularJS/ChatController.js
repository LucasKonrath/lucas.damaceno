var modulo = angular.module('chatApp', []);

modulo.controller('ChatController', function ($scope, chatService) {
    $scope.mensagens = {};
    $scope.enviarMensagem = enviarMensagem;
    $scope.obterMensagens = obterMensagens;    

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
        .enviarMensagem()
        .then(mensagens => {
            obterMensagens();
        })
    }
});