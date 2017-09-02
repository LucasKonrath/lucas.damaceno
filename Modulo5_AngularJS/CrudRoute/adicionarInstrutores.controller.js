app.controller('adicionarInstrutoresController', function($scope,$http,$routeParams, instrutorService, aulaService){

    $scope.listarInstrutores = listarInstrutores;
    function listarInstrutores(){
        instrutorService.list().then(function(response){
            $scope.listaDeInstrutores = response.data;
        });
    }
    $scope.insereInstrutor = insereInstrutor;
    function insereInstrutor(){
        let instrutor = {
            nome:$scope.nomeInstrutorAInserir,
            sobrenome:$scope.sobrenomeInstrutorAInserir,
            idade:$scope.idadeInstrutorAInserir,
            email:$scope.emailInstrutorAInserir,
            dandoAula:$scope.dandoAulalInstrutorAInserir,
            urlFoto: $scope.fotoInstrutorAInserir || "https://cdn.pensador.com/img/authors/me/st/mestre-dos-magos-l.jpg",
        }
        
        let idAulasInstrutor = [];
        if(typeof $scope.selecionarAulaInstrutor === "undefined"){
            idAulasInstrutor.push(0);
        }
        else{
            for(aulas of $scope.selecionarAulaInstrutor){
            idAulasInstrutor.push(aulas.id);
        }
        }
        instrutor.aula = idAulasInstrutor;
        instrutorService.create(instrutor).then(function(response){
            swal("Feito!", "Instrutor adicionado com sucesso!", "success");
            $scope.listarInstrutores();
        });

    }
    $scope.listarAulas = listarAulas; 
    function listarAulas (){
        aulaService.list().then(function(response){

            $scope.listaDeAulas = response.data;
            $scope.listaDeAulas.splice(0,1);

        });}

    $scope.getAulaByID = function(ID){
        if (typeof $scope.listaDeAulas === 'undefined') return; 
        for(aula of $scope.listaDeAulas){
            if(aula.id === ID) return aula;
        }
        return;
    }

});



