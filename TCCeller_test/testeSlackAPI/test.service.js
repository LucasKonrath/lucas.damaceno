modulo.factory("testService", function ($http) {
    return ({
        enviarMensagem:enviarMensagem,
        serializarMensagem:serializarMensagem
    });

    function enviarMensagem(){
   
        return $http.get("https://slack.com/api/chat.postMessage?token=xoxp-166684486960-167730704512-207888517604-333d604d7b051b2c7138d140e39ea825&channel=%40lucasdamaceno&text=como%20funciona%20isso%20aqui&icon_emoji=%3Ahachi-roku%3A&pretty=1");

    }
    
    function serializarMensagem(){
   console.log(paramSerializer({a:1}));
    }
 
  

});