app.factory('aulaService', function ($http) {
  let urlBase = 'http://localhost:3000';

  function getTodasAsAulas() {
    return $http.get(urlBase + '/aula');
  };

  function getAulaPorId(id) {
    return $http.get(urlBase + '/aula' + '/' + id);
  };

  function atualizar(aula) {
    return $http.put(urlBase + '/aula' + '/' + aula.id, aula);
  };

  function criar(aula) {
    let objetoAulaCriar = {nome:aula};
    return $http.post(urlBase + '/aula', objetoAulaCriar);
  };
    
function deletar(aula){
    
    return $http.delete(urlBase+'/aula' + '/' + aula.id);
}    
     

  return {
    list: getTodasAsAulas,
    findById: getAulaPorId,
    update: atualizar,
    create: criar,
      delete: deletar
  };
});


app.factory('instrutorService', function ($http) {
  let urlBase = 'http://localhost:3000';

  function getTodosInstrutores() {
    return $http.get(urlBase + '/instrutor');
  };

  function getInstrutorPorId(id) {
    return $http.get(urlBase + '/instrutor' + '/' + id);
  };

  function atualizar(instrutor) {
    return $http.put(urlBase + '/instrutor' + '/' + instrutor.id, instrutor);
  };

  function criar(instrutor) {
    let objetoInstrutorCriar = {nome:instrutor.nome, sobrenome:instrutor.sobrenome,idade:instrutor.idade,
    email:instrutor.email,dandoAula:instrutor.dandoAula,aula:instrutor.aula,urlFoto:instrutor.urlFoto
                                
                               };
    return $http.post(urlBase + '/instrutor', objetoInstrutorCriar);
  };
    
function deletar(instrutor){
    
    return $http.delete(urlBase+'/instrutor' + '/' + instrutor.id);
}    
     

  return {
    list: getTodosInstrutores,
    findById: getInstrutorPorId,
    update: atualizar,
    create: criar,
      delete: deletar
  };
});