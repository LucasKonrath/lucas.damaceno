public class ConstelacaoInvalidaException extends Exception{
    public ConstelacaoInvalidaException(){
        super("Verifique se a constelação é válida");
    }
    public ConstelacaoInvalidaException(String erro){
        super(erro);
    }
}