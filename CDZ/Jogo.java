public class Jogo{
    private static void imprimirArgumentos(String[] args)throws Exception{
        try{
            System.out.println(args[0]);
        }
        catch(ArrayIndexOutOfBoundsException ai){
            System.out.println("Ops.. verifique os argumentos");
            ai.printStackTrace();
            throw new Exception("Erro de índice"); //aborta a execução do método.
        }
        catch(Exception e){
            //TODO: fazer algo
            System.out.println(":(");
            e.printStackTrace();}
    }

    public static void main(String[] args){
        try{
            System.out.println("Iniciando o jogo...");
            System.out.println("Ea sports.... It's in the game");
            imprimirArgumentos(args);
        }catch(Exception e){
            System.out.println("Ih, deu guru.");
        }finally{
                System.out.println("kkkkkk eae men");
        }
    }
}