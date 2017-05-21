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

    function getInstrutorByID (ID){

        for(instrutor of instrutores){
            if(instrutor.id === ID) return instrutor;
        }
        return;
    }


    $scope.insereAula = function (){
        console.log($scope.aulaAInserir);
        let arrayNomesAulas = [];
        for (var i=0; i < $scope.aulas.length; i++) {
            if($scope.aulas[i].nome.toLowerCase() === $scope.aulaAInserir.toLowerCase()) {alert('Aula já cadastrada.'); return;}
        }
        let aulaAAdd = {id:ID,nome:$scope.aulaAInserir, estaSendoUtilizada: $scope.aulaUtilizada || false};
        ID++;
        $scope.aulas.push(aulaAAdd);
    }
    $scope.modificaAula = function(){
        if($scope.modificarAula.$invalid) {
            
            alert('Informações insuficientes.');
            return;
            
        }
        console.log($scope.selecionarAula);
        console.log($scope.novoNome);
        console.log($scope.modificarAulaUtilizada);
        let arrayNomesAulas = [];
        let indiceAPovoar;
        let povoar = false;
        let mesmoNome = $scope.selecionarAula.nome.toLowerCase() === $scope.novoNome.toLowerCase();
        for (var i=0; i < $scope.aulas.length; i++) {
            if($scope.aulas[i].nome.toLowerCase() === $scope.novoNome.toLowerCase()){ if(mesmoNome === false){alert('Aula já cadastrada.'); return;}}
            if ($scope.aulas[i].id === $scope.selecionarAula.id) {
                indiceAPovoar = i;
                povoar = true;
            }
        }
        if(povoar === true) {
            $scope.aulas[indiceAPovoar].nome = $scope.novoNome;
            $scope.aulas[indiceAPovoar].estaSendoUtilizada = ($scope.modificarAulaUtilizada || false);
        }
        
        
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
        console.log($scope.adicionarInstrutor);
        if($scope.adicionarInstrutor.$valid === true){
        let aulasAdicionarInstrutor = [];
        if(typeof $scope.selecionarAulaInstrutor !== 'undefined'){
        for(aula of $scope.selecionarAulaInstrutor){ 
            aulasAdicionarInstrutor.push(aula.id);
        }
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
            return;
        }
        alert('Formulário Inválido.');
    }

    $scope.modificaInstrutor = function(){
        let aulasAdicionarInstrutor = [];
        let instrutorPovoar = getInstrutorByID($scope.instrutorAModificar.id);
        let mesmoNome = $scope.instrutorAModificar.nome ===  instrutorPovoar.nome;
        let mesmoEmail = $scope.instrutorAModificar.email ===  instrutorPovoar.email;
        if(typeof ($scope.selecionarAulaATrocar) !== 'undefined')
        {for(aula of $scope.selecionarAulaATrocar){ 
            aulasAdicionarInstrutor.push(aula.id);
        }}
        $scope.fotoInstrutorTrocar = $scope.fotoInstrutorTrocar|| 'https://s-media-cache-ak0.pinimg.com/736x/ea/3d/cf/ea3dcff8ed8e8939d98c96b81f747623.jpg';
        let instrutorModificar = {id:$scope.instrutorAModificar.id,nome:$scope.nomeInstrutorTrocar,sobrenome:$scope.sobrenomeInstrutorTrocar,
                                  email:$scope.emailInstrutorTrocar,idade:$scope.idadeInstrutorTrocar,
                                  dandoAula:$scope.dandoAulaInstrutorTrocar,urlFoto:$scope.fotoInstrutorTrocar,aula:aulasAdicionarInstrutor}
        console.log($scope.selecionarAulaATrocar);
        console.log(instrutorModificar);
        if((!existeInstrutorComNome($scope.nomeInstrutorTrocar,mesmoNome) || mesmoNome) && (!existeInstrutorComEmail($scope.emailInstrutorTrocar,mesmoEmail) || mesmoEmail))
        {
            $scope.instrutores.splice(instrutorModificar.id,1);
            $scope.instrutores.push(instrutorModificar);
        }


    }

    function existeInstrutorComNome(instrutorTestar, comparacao){
        let comparar = comparacao || false;
        for(instrutorTestado of instrutores){
            if(instrutorTestado.nome === instrutorTestar) { if(comparar === false)alert('Instrutor com este nome já cadastrado.'); return true;}
        }

        return false;
    }

    function existeInstrutorComEmail(emailTestar,comparacao){
        let comparar = comparacao || false;
        for(instrutorTestado of instrutores){
            if(instrutorTestado.email.toLowerCase() === emailTestar.toLowerCase()) { if(comparar === false) alert('Instrutor com este email já cadastrado.'); return true;}
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

    $scope.povoarMudancas = function(){
        if(typeof $scope.instrutorAModificar.id !== 'undefined'){
            let instrutorPovoar = getInstrutorByID($scope.instrutorAModificar.id);
            $scope.ImagemInstrutorTrocar = instrutorPovoar.urlFoto;
            $scope.nomeInstrutorTrocar  = instrutorPovoar.nome;
            $scope.sobrenomeInstrutorTrocar = instrutorPovoar.sobrenome;
            $scope.idadeInstrutorTrocar = instrutorPovoar.idade;
            $scope.emailInstrutorTrocar = instrutorPovoar.email;
            $scope.dandoAulaInstrutorTrocar = instrutorPovoar.dandoAula;
            $scope.fotoInstrutorTrocar = instrutorPovoar.urlFoto;
        }

    }
    
    



})

