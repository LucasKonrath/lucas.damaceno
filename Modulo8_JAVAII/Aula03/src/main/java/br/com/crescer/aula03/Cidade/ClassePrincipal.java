package br.com.crescer.aula03.Cidade;

/**
 * @author carloshenrique
 */
public class ClassePrincipal {
    
    public static void main(String[] args) {
        
        final CidadeDao cidadeDao = new CidadeDaoImpl();
        
        final Cidade cidade = new Cidade();
        
        
        cidade.setId(22420l);
        cidade.setEstado(14l);
        cidade.setNome("Joaozinho Dinheiros");
        cidade.setId(1l);
        cidadeDao.insert(cidade);
        
     
        
        
    }
    
}