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
    var envio = $http.post(urlBase + '/aula', objetoAulaCriar).then(function (response) {
    swal("Feito!", "Aula Inserida Com Sucesso!", "success");
    
  });
     
  };

  return {
    list: getTodasAsAulas,
    findById: getAulaPorId,
    update: atualizar,
    create: criar
  };
});