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