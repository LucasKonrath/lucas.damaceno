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
        dandoAula: true,                  // true ou false
        aula: [-10],                     // Opcional (array)
        urlFoto: 'http://sou.gohorseprocess.com.br/wp-content/uploads/2017/05/horse21.png'  // Opcional (porém tem uma default de livre escolha)
    }
    
    let instrutores = [instrutor];
    $scope.instrutores = instrutores;
    let aulainicial= {nome:'Extreme Go Horse', id:-10,estaSendoUtilizada:true};
    let aulas = [];
    aulas.push(aulainicial);
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
            if($scope.aulas[i].nome.toLowerCase() === $scope.aulaAInserir.toLowerCase()) {swal({
                title: "Ó ceus!",
                text: "Não é possivel cadastrar esta aula. Já há uma aula com o mesmo nome.",
                imageUrl: "thumbsDOWN.gif",
                confirmButtonText: "Ok."
            }); 
              return;}
          }
          let aulaAAdd = {id:ID,nome:$scope.aulaAInserir, estaSendoUtilizada: $scope.aulaUtilizada || false};
          ID++;
          $scope.aulas.push(aulaAAdd);
          swal({
            title: "Feito!",
            text: "Aula cadastrada com sucesso.",
            imageUrl: "thumbsUP.gif",
            confirmButtonText: "Ok."
        });
      }
      $scope.modificaAula = function(){
        if($scope.modificarAula.$invalid) {

            swal({
                title: "Ó ceus!",
                text: "Não é possivel excluir esta aula. Ela está sendo utilizada.",
                imageUrl: "thumbsDOWN.gif",
                confirmButtonText: "Ok."
            });
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
            if($scope.aulas[i].nome.toLowerCase() === $scope.novoNome.toLowerCase()){ if(mesmoNome === false){swal({
                title: "Ó ceus!",
                text: "Não é possivel modificar esta aula. Já há uma aula com o mesmo nome.",
                imageUrl: "thumbsDOWN.gif",
                confirmButtonText: "Ok."
            }); return;}}
                if ($scope.aulas[i].id === $scope.selecionarAula.id) {
                    indiceAPovoar = i;
                    povoar = true;
                }
            }
            if(povoar === true) {
                $scope.aulas[indiceAPovoar].nome = $scope.novoNome;
                $scope.aulas[indiceAPovoar].estaSendoUtilizada = ($scope.modificarAulaUtilizada || false);
                swal({
                    title: "Feito!",
                    text: "Aula modificada com sucesso.",
                    imageUrl: "thumbsUP.gif",
                    confirmButtonText: "Ok."
                });
                    $scope.selecionarAula = aulas[0].nome;
            }


        }

        $scope.excluiAula = function(){
            console.log($scope.selecionarAula);
            if($scope.selecionarAula.estaSendoUtilizada===true) {swal({
                title: "Ó ceus!",
                text: "Não é possivel excluir esta aula. Ela está sendo utilizada.",
                imageUrl: "thumbsDOWN.gif"
            });
               return;}
               for (var i=0; i < $scope.aulas.length; i++) {
                if ($scope.aulas[i].id === $scope.selecionarAula.id) {
                    $scope.aulas.splice([i],1);
                    swal({
                        title: "Feito!",
                        text: "Aula excluida com sucesso.",
                        imageUrl: "thumbsUP.gif",
                        confirmButtonText: "Ok."
                    });
                    $scope.selecionarAula = aulas[0].nome;
                    return;
                }
            }

        }

        $scope.insereInstrutor = function(){
          

            if($scope.adicionarInstrutor.inputInstrutorEmail.$invalid){
                swal({
                    title: "Ó ceus!",
                    text: "Email Inválido Digitado.",
                    imageUrl: "thumbsDOWN.gif",
                    confirmButtonText: "Ok."
                });
                return;
            }

            if($scope.adicionarInstrutor.$valid === true){
                let aulasAdicionarInstrutor = [];
                if(typeof $scope.selecionarAulaInstrutor !== 'undefined'){
                    for(aula of $scope.selecionarAulaInstrutor){ 
                        aulasAdicionarInstrutor.push(aula.id);
                    }
                }





                $scope.fotoInstrutorAInserir = $scope.fotoInstrutorAInserir || 'http://sou.gohorseprocess.com.br/wp-content/uploads/2017/05/horse21.png';
                let instrutorAdicionar = {
                    id:IDInstrutor,
                    nome:$scope.nomeInstrutorAInserir,
                    sobrenome:$scope.sobrenomeInstrutorAInserir,
                    email:$scope.emailInstrutorAInserir,
                    idade:$scope.idadeInstrutorAInserir,
                    dandoAula:$scope.dandoAulalInstrutorAInserir,
                    urlFoto:$scope.fotoInstrutorAInserir,
                    aula:aulasAdicionarInstrutor
                }
                console.log($scope.selecionarAulaInstrutor);
                console.log(instrutorAdicionar);
                if(!existeInstrutorComNome(instrutorAdicionar.nome) && !existeInstrutorComEmail(instrutorAdicionar.email))
                {   IDInstrutor++;
                    instrutorAdicionar.id=IDInstrutor;
                    $scope.instrutores.push(instrutorAdicionar);
                    swal({
                        title: "Feito!",
                        text: "Instrutor adicionado com sucesso.",
                        imageUrl: "thumbsUP.gif",
                        confirmButtonText: "Ok."
                    });
                }
                return;
            }
            swal({
                title: "Ó ceus!",
                text: "Há campos  preenchidos incorretamente.",
                imageUrl: "thumbsDOWN.gif",
                confirmButtonText: "Ok."
            });
        }

        $scope.modificaInstrutor = function(){
            let aulasAdicionarInstrutor = [];
            let instrutorPovoar = getInstrutorByID($scope.instrutorAModificar.id);
            let mesmoNome = $scope.instrutorAModificar.nome ===  instrutorPovoar.nome;
            let mesmoEmail = $scope.instrutorAModificar.email ===  instrutorPovoar.email;
            if(typeof $scope.emailInstrutorTrocar === 'undefined'){
                swal({
                    title: "Ó ceus!",
                    text: "Email Inválido Digitado.",
                    imageUrl: "thumbsDOWN.gif",
                    confirmButtonText: "Ok."
                });
                return;
            }
            if(typeof ($scope.selecionarAulaATrocar) !== 'undefined')
            {
                for(aula of $scope.selecionarAulaATrocar){ 
                    aulasAdicionarInstrutor.push(aula.id);
                }
            }
            $scope.fotoInstrutorTrocar = $scope.fotoInstrutorTrocar|| 'http://sou.gohorseprocess.com.br/wp-content/uploads/2017/05/horse21.png';
            let instrutorModificar = {
                id:$scope.instrutorAModificar.id,
                nome:$scope.nomeInstrutorTrocar,
                sobrenome:$scope.sobrenomeInstrutorTrocar,
                email:$scope.emailInstrutorTrocar,
                idade:$scope.idadeInstrutorTrocar,
                dandoAula:$scope.dandoAulaInstrutorTrocar || false,
                urlFoto:$scope.fotoInstrutorTrocar,
                aula:aulasAdicionarInstrutor
            }
            console.log($scope.selecionarAulaATrocar);
            console.log(instrutorModificar);
            if((!existeInstrutorComNome($scope.nomeInstrutorTrocar,mesmoNome) || mesmoNome) && (!existeInstrutorComEmail($scope.emailInstrutorTrocar,mesmoEmail) || mesmoEmail))
            {
                $scope.instrutores.splice(instrutores.indexOf(getInstrutorByID($scope.instrutorAModificar.id)),1);
                $scope.instrutores.push(instrutorModificar);
                swal({
                    title: "Feito!",
                    text: "Instrutor modificado com sucesso.",
                    imageUrl: "thumbsUP.gif",
                    confirmButtonText: "Ok."
                });
            }


        }

        function existeInstrutorComNome(instrutorTestar, comparacao){
            let comparar = comparacao || false;
            for(instrutorTestado of instrutores){
                if(instrutorTestado.nome === instrutorTestar) { 
                    if(comparar === false){
                        swal({
                            title: "Ó ceus!",
                            text: "Não é possivel cadastrar este instrutor. Já há um  com o mesmo nome.",
                            imageUrl: "thumbsDOWN.gif",
                            confirmButtonText: "Ok."
                        });
                    } 
                    return true;
                }
            }

            return false;
        }


        $scope.excluiInstrutor = function(){
            let instrutorExcluir = getInstrutorByID($scope.instrutorAModificar.id)
            if(instrutorExcluir.dandoAula===true) {
                {
                    swal({
                        title: "Ó ceus!",
                        text: "Não é possivel excluir este instrutor. Está dando aula.",
                        imageUrl: "thumbsDOWN.gif",
                        confirmButtonText: "Ok."
                    });
                } return;
            }



            for (var i=0; i < $scope.instrutores.length; i++) {
                if ($scope.instrutores[i].id === $scope.instrutorAModificar.id) {

                    $scope.instrutores.splice([i],1);
                    instrutorPovoar = {};
                    $scope.povoarMudancas();

                }
            }
            swal({
                title: "Feito!",
                text: "Instrutor excluido com sucesso.",
                imageUrl: "thumbsUP.gif",
                confirmButtonText: "Ok."
            });    
        }

        $scope.povoarMudancas = function(vazio){
            if($scope.instrutorAModificar !== null && typeof $scope.instrutorAModificar.id !== 'undefined'){
                let instrutorPovoar = getInstrutorByID($scope.instrutorAModificar.id) || '';
                $scope.ImagemInstrutorTrocar = instrutorPovoar.urlFoto || '';
                $scope.nomeInstrutorTrocar  = instrutorPovoar.nome || '';
                $scope.sobrenomeInstrutorTrocar = instrutorPovoar.sobrenome || '';
                $scope.idadeInstrutorTrocar = instrutorPovoar.idade || '';
                $scope.emailInstrutorTrocar = instrutorPovoar.email || '';
                $scope.dandoAulaInstrutorTrocar = instrutorPovoar.dandoAula || '';
                $scope.fotoInstrutorTrocar = instrutorPovoar.urlFoto || '';
            }

        }
        
        $scope.povoarAulaMod = function(){
            let aulaPovoar = $scope.getAulaByID($scope.selecionarAula.id);
            $scope.novoNome = aulaPovoar.nome;
            $scope.modificarAulaUtilizada = aulaPovoar.estaSendoUtilizada;
        }

        $scope.temInstrutorComEmail = existeInstrutorComEmail;

        var existeInstrutorComEmail = function (emailTestar,comparacao){
            let comparar = comparacao || false;
            for(instrutorTestado of instrutores){
                if(instrutorTestado.email.toLowerCase() === emailTestar.toLowerCase()) { if(comparar === false) {swal(
                    {
                        title: "Erro!",
                        text: "E-Mail digitado já está cadastrado.",
                        type: "error",
                        confirmButtonText: "Ok."
                    });} 
                    return true;}
                }

                return false;
            }
        })

