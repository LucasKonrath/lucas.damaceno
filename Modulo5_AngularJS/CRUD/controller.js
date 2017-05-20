var modulo = angular.module('SistemaCRUD',[]);





modulo.controller('controllerCRUD', function($scope,$filter){

    let ID = 0;
    let IDInstrutor = 0;
    let instrutor = {
        id: 0,                            // Gerado
        nome: 'Lucas',                     // Obrigatório (length = min 3, max 20)
        sobrenome: 'Damaceno',           // Opcional (length = max 30)
        idade: 20,                        // Obrigatório (max 90)
        email: 'lucas.damaceno@cwi.com.br',        // Obrigatório (type=email)
        dandoAula: false,                  // true ou false
        aula: [1, 4],                     // Opcional (array)
        urlFoto: 'https://s-media-cache-ak0.pinimg.com/736x/ea/3d/cf/ea3dcff8ed8e8939d98c96b81f747623.jpg'  // Opcional (porém tem uma default de livre escolha)
    }
    let instrutores = [instrutor];
    $scope.instrutores = instrutores;



    let aulas = [];
    console.log(aulas);
    $scope.aulas = aulas;

    $scope.getAulaByID = function(ID){

        for(aula of aulas){
            if(aula.id === ID) return aula;
        }
        return;
    }


    $scope.insereAula = function (){
        console.log($scope.aulaAInserir);
        let arrayNomesAulas = [];
        for (var i=0; i < $scope.aulas.length; i++) {
            arrayNomesAulas +=  $scope.aulas[i].nome;
            if(arrayNomesAulas.includes($scope.aulaAInserir)) {alert('Aula já cadastrada.'); return;}
        }
        let aulaAAdd = {id:ID,nome:$scope.aulaAInserir, estaSendoUtilizada: false};
        ID++;
        $scope.aulas.push(aulaAAdd);
    }
    $scope.modificaAula = function(){
        console.log($scope.selecionarAula);
        console.log($scope.novoNome);
        let arrayNomesAulas = [];
        let indiceAPovoar;
        let povoar = false;
        for (var i=0; i < $scope.aulas.length; i++) {
            if($scope.aulas[i].nome.toLowerCase() === $scope.novoNome.toLowerCase()) {alert('Aula já cadastrada.'); return;}
            if ($scope.aulas[i].id === $scope.selecionarAula.id) {
                indiceAPovoar = i;
                povoar = true;
            }
        }
        if(povoar === true) $scope.aulas[indiceAPovoar].nome = $scope.novoNome;
    }

    $scope.excluiAula = function(){
        console.log($scope.selecionarAula);
        if($scope.selecionarAula.estaSendoUtilizada===true) {alert('Não é possível excluir esta aula. Está sendo utilizada.'); return;}
        for (var i=0; i < $scope.aulas.length; i++) {
            if ($scope.aulas[i].id === $scope.selecionarAula.id) {
                $scope.aulas.splice([i],1);
                return;
            }
        }

    }

    $scope.insereInstrutor = function(){
        IDInstrutor++;
        let aulasAdicionarInstrutor = [];
        for(aula of $scope.selecionarAulaInstrutor){ 
            aulasAdicionarInstrutor.push(aula.id);
        }
        $scope.fotoInstrutorAInserir = $scope.fotoInstrutorAInserir || 'https://s-media-cache-ak0.pinimg.com/736x/ea/3d/cf/ea3dcff8ed8e8939d98c96b81f747623.jpg';
        let instrutorAdicionar = {id:IDInstrutor,nome:$scope.nomeInstrutorAInserir,sobrenome:$scope.sobrenomeInstrutorAInserir,
                                  email:$scope.emailInstrutorAInserir,idade:$scope.idadeInstrutorAInserir,
                                  dandoAula:$scope.dandoAulalInstrutorAInserir,urlFoto:$scope.fotoInstrutorAInserir,aula:aulasAdicionarInstrutor}
        console.log($scope.selecionarAulaInstrutor);
        console.log(instrutorAdicionar);
        if(!existeInstrutorComNome(instrutorAdicionar.nome) && !existeInstrutorComEmail(instrutorAdicionar.email))
        {
            $scope.instrutores.push(instrutorAdicionar);
        }


    }

    function existeInstrutorComNome(instrutorTestar){
        for(instrutorTestado of instrutores){
            if(instrutorTestado.nome === instrutorTestar) { alert('Instrutor com este nome já cadastrado.'); return true;}
        }

        return false;
    }

    function existeInstrutorComEmail(emailTestar){
        for(instrutorTestado of instrutores){
            if(instrutorTestado.email.toLowerCase() === emailTestar.toLowerCase()) { alert('Instrutor com este email já cadastrado.'); return true;}
        }

        return false;
    }
    $scope.excluiInstrutor = function(){
        if($scope.instrutorAExcluir.dandoAula===true) {alert('Não é possível excluir este instrutor. Está lecionando agora.'); return;}
        for (var i=0; i < $scope.instrutores.length; i++) {
            if ($scope.instrutores[i].id === $scope.instrutorAExcluir.id) {
                $scope.instrutores.splice([i],1);
                return;
            }
        }

    }



})

