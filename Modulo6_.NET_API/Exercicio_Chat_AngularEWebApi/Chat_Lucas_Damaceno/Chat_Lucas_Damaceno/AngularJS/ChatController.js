var modulo = angular.module('chatApp', []);

modulo.controller('ChatController', function ($scope, chatService) {
    $scope.mensagens = {};
    $scope.enviarMensagem = enviarMensagem;
    $scope.obterMensagens = obterMensagens;    
    $scope.enviarUser = enviarUser;
    usuarioCadastrado = localStorage.getItem("nomeUser") !== null;
    $scope.usuarioCadastrado = usuarioCadastrado;
    setInterval(function(){ 
        
                            obterMensagens(true); 
                          
                          }, 1000);
    
    function enviarUser() {
        
        localStorage.setItem("nomeUser",$scope.nomeUser);
        localStorage.setItem("fotoUser",$scope.imagemUser);
        $scope.usuarioCadastrado = true;
    }
    
    
    function obterMensagens(birlar) {
        chatService
        .obterMensagens()
        .then(response => {
            var scopeAntigo = $scope.mensagens.length;
            $scope.mensagens = response.data;
            if($scope.mensagens.length !== scopeAntigo && birlar == true){
                var birl = document.getElementById('birl');
                birl.play();
            }
        })
    }

    function enviarMensagem() {
        chatService
        .enviarMensagem(localStorage.getItem("nomeUser"), localStorage.getItem("fotoUser"), $scope.textoMensagem)
        .then(mensagens => {
            $scope.textoMensagem=" ";
            obterMensagens(false);
        })
    }
});