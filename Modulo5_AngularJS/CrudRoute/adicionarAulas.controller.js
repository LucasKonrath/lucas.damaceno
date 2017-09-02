



app.controller('adicionarAulasController', function ($scope, $routeParams, aulaService) {
    $scope.insereAula = function(aula){
        let inserir = true;
        aulaService.list().then(function (response){
            var aulas = response.data;
            console.log(aulas);
            for(aulaTestar of aulas){
                if (aulaTestar.nome.toLowerCase() === aula.toLowerCase()) inserir = false;
                swal({
                    title: "Error!",
                    text: "Nome ja cadastrado!",
                    type: "error",
                    confirmButtonText: "Cool"
                });
            }
            if(inserir) {
                aulaService.create(aula).then(function (response) {

                    swal("Feito!", "Aula Inserida Com Sucesso!", "success");
                    $scope.listarAulas();
                });
            }
        });

    }


    $scope.povoarAulaMod = function(){
        if(typeof $scope.selecionarAula !== 'undefined' && $scope.selecionarAula !== null){
            let aulaPovoar = $scope.getAulaByID($scope.selecionarAula.id) || '';
            $scope.novoNome = aulaPovoar.nome;
            $scope.modificarAulaUtilizada = aulaPovoar.estaSendoUtilizada;
        }
    }

    $scope.modificaAula = modificaAula;


    function modificaAula(){
        var aulaAAtualizar = $scope.getAulaByID($scope.selecionarAula.id);
        aulaAAtualizar = aulaAAtualizar.id;
        console.log(aulaAAtualizar);
        var aulaNova = {id:aulaAAtualizar,nome:$scope.novoNome};
        console.log(aulaNova);
        aulaService.update(aulaNova).then(function(response){
            swal("Feito!", "Aula Modificada Com Sucesso!", "success");
            $scope.listarAulas();
            $scope.novoNome =  '';
        });
    }

    $scope.excluiAula = excluiAula;
    function excluiAula(){

        aulaService.delete($scope.getAulaByID($scope.selecionarAula.id)).then(function(response){
            swal("Feito!", "Aula Deletada Com Sucesso!", "success");
            $scope.novoNome = '';
            $scope.listarAulas();
        });

    }

    $scope.getAulaByID = function(ID){

        for(aula of $scope.listaDeAulas){
            if(aula.id === ID) return aula;
        }
        return;
    }

    $scope.listarAulas = listarAulas; 
    function listarAulas (){
        aulaService.list().then(function(response){

            $scope.listaDeAulas = response.data; 
            $scope.listaDeAulas.splice(0,1);
        });}

    $scope.findById = findById;

    function findById(id) {
        aulaService.findById(id).then(function (response) {
            $scope.aula = response.data;
        });
    };
});






