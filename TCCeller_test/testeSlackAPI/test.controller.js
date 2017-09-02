modulo.controller('TestController', function ($scope, testService) {

   $scope.testar = testar;
    
    
    
     function testar(){
         console.log('entrei aqui');
        testService.enviarMensagem().then(

            response=> 
            {
                console.log(response);
                testService.serializarMensagem();
            }

        )

    }
    
     

});