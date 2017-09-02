package br.com.crescer.aula03.Pais;

/**
 * @author carloshenrique
 */
public class ClassePrincipal {
    
    public static void main(String[] args) {
        
        final PaisDao paisDao = new PaisDaoImpl();
        
        final Pais pais = new Pais();
        
        pais.setId(1l);
        pais.setNome("murica");
        pais.setSigla("USA");
        
        
     
        
        
    }
    
}