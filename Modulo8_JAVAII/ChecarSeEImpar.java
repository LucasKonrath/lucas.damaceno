
import java.util.Scanner;


class ChecarSeEImpar {
  public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
			int valorInserido = Integer.parseInt(scanner.nextLine());
			if(valorInserido % 2 == 0) 
				System.out.println("Numero: " + valorInserido + " e par.");
			else 
				System.out.println("Numero: " + valorInserido + " e impar.");
        } catch (Exception e) {
            //...
        }
    }
}